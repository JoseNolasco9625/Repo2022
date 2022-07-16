package Common;


import Browser_Manager.DriverManager;
import Browser_Manager.DriverManagerFactory;
import Browser_Manager.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class BaseTestDos
{
    //********INSTANCIAS*********
    public static WebDriver driver = null;
    private DriverManager driverManager;
    private static int numberOfCase = 0;
    //***************************

    @BeforeTest
    public void beforeTestMethod() throws Exception
    {
        numberOfCase ++;
        System.out.println("Se esta ejecutando el escenario Numero: " + numberOfCase);
        driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
        driver = driverManager.getDriver();
        driver.get(Config.AMZ);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    @AfterTest
    public void tearDown()
    {
        System.out.println("El escenario " + numberOfCase + "se ejecuto correctamente");
        driver.quit();
    }
}
