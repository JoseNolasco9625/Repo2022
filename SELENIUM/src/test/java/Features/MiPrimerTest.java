package Features;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class MiPrimerTest
{
    private WebDriver driver;

    @BeforeTest
    public void setup() throws InterruptedException
    {
        //configuracion del nombre del driver de Chrome no cambia, despues del coma es la ubicacion de donde se tiene el driver
        System.setProperty("webdriver.chrome.driver" , "src/main/resources/Drivers/chromedriver.exe");

        //Se crea la instancia u objeto del navegador
        driver = new ChromeDriver();

        //Maximisa el navegador
        driver.manage().window().maximize();

        //Enviamos la url del navegador
        driver.get("https://www.amazon.com.mx/");
        Thread.sleep(2000);

    }

    @Test
    public void testAmazon () throws InterruptedException
    {
        WebElement inputBusqueda = driver.findElement(By.id("twotabsearchtextbox"));
        Thread.sleep(1000);
        inputBusqueda.click();
        Thread.sleep(1000);
        inputBusqueda.sendKeys("Alexa");
        inputBusqueda.submit();
        Thread.sleep(1000);

    }

    @AfterTest
    public void tearDown ()
    {
        //Cierra el navegador
        driver.close();
        //Se quita la instancia de Selenium
        driver.quit();
    }

}
