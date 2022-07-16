package Common;

import Browser_Manager.DriverManager;
import Browser_Manager.DriverManagerFactory;
import Browser_Manager.DriverType;
import Features.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BaseTest
{
    // *********INSTANCIAS*******

    protected static WebDriver driver = null ;
    Login login = new Login();
    private DriverManager driverManager;

    @BeforeTest
    public void setup() throws InterruptedException
    {

        driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
        driver = driverManager.getDriver();
        driver.get(Config.URL_QA);
        //Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        //Se realiza el login
        login.miLogin(driver);
    }



    @AfterTest
    public void tearDown ()
    {
        driver.close();
        driver.quit();
    }
}