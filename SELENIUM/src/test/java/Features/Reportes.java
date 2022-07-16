package Features;

import Browser_Manager.DriverManager;
import Browser_Manager.DriverManagerFactory;
import Browser_Manager.DriverType;
import Common.Config;
import Elements.ElementsSelects;
import Utils.SeleniumUtils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Reportes
{
    public static WebDriver driver = null;
    Login login = new Login();
    private DriverManager driverManager;
    private static int numberOfCase = 0;
    static ExtentReports report;
    static ExtentTest test;
    SeleniumUtils utils = new SeleniumUtils();
    ElementsSelects elementsSelects = new ElementsSelects();

    @BeforeTest
    public void setUp () throws InterruptedException
    {
        numberOfCase ++;
        System.out.println("Se esta ejecutando el caso numero: " + numberOfCase);
        driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
        driver = driverManager.getDriver();
        driver.get(Config.URL_QA);
        report = new ExtentReports("C:\\Users\\Jose Nolasco\\Desktop\\Automation\\SELENIUM\\Reports\\report.html", true);
        test = report.startTest("Automation Report");

        //Login
        login.miLogin(driver);
                    test.log(LogStatus.INFO, "Se realizó correctamente el login");
    }

    @Test
    public void ListaConClicks () throws Exception
    {
        utils.Click(elementsSelects.TapWoman(driver));

        utils.Click(elementsSelects.BottonMasTops(driver));

        utils.Click(elementsSelects.BottonTSshirts(driver));

        //****Seleccionar OPCIONES DE LISTAS CON CLICS********
        //No se recomienda utilizar dar clics en las opciones de un select
        utils.Click(elementsSelects.SelectSort(driver));
        utils.wating(driver, 1000);
        String opcionEsperada = "In stock";
        String opcionBuscar = String.format("//option[text()='%s']", opcionEsperada);
        WebElement option = driver.findElement(By.xpath(opcionBuscar));
        utils.Click(option);
        utils.wating(driver, 1000);
                    test.log(LogStatus.PASS, test.addScreenCapture(utils.getScreenshot(driver,"Screen_Uno")) +  "Se selecciona correctamente dando Clic");

    }

    @Test
    public void ListaConSendKeys () throws InterruptedException
    {
        utils.Click(elementsSelects.TapWoman(driver));
        utils.wating(driver, 1000);
        utils.Click(elementsSelects.BottonMasTops(driver));
        utils.wating(driver, 1000);
        utils.Click(elementsSelects.BottonTSshirts(driver));
        utils.wating(driver, 1000);

        //******Manejo de listas con send keys*******+
        //************Esta opcion es recomendable**********
        String opcionEsperada = "In stock";
        elementsSelects.SelectSort(driver).sendKeys(opcionEsperada);
        utils.wating(driver, 1000);
                    test.log(LogStatus.PASS, "Se selecciona correctamente usando SendKeys");

    }

    @Test
    public void ListaUsandoClaseSelect() throws InterruptedException
    {
        utils.Click(elementsSelects.TapWoman(driver));
        utils.wating(driver, 1000);
        utils.Click(elementsSelects.BottonMasTops(driver));
        utils.wating(driver, 1000);
        utils.Click(elementsSelects.BottonTSshirts(driver));
        utils.wating(driver, 1000);

        //****************   Manejo de listas con clase Select **********
        //****Esta opcion es la mas recomendable*******
        //selectByVisibleText
        String opcionEsperada = "In stock";
        elementsSelects.SelectSort(driver);
        Select selectLista = new Select(elementsSelects.SelectSort(driver));
        //selectLista.selectByVisibleText(opcionEsperada);
        //selectLista.selectByValue("quantity:desc");
        selectLista.selectByIndex(6);
        utils.wating(driver, 1000);
                    test.log(LogStatus.FAIL, "Se selecciona incorrectamente usando clase Select");
    }

    @AfterTest
    public void TearDown ()
    {
        driverManager.quitDriver();
        report.endTest(test);
        report.flush();
    }

}
