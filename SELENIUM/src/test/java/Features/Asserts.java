package Features;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Asserts
{
    private WebDriver driver;
    @BeforeTest
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver" , "src/main/resources/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void AssertTrue ()
    {
        //El assert True se utiliza para realizar validacioneS para scripts positivos
        WebElement user = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("passContainer"));

        //Se valida que los elementos esten presentes, lo cual nos dara como resultado que los scripts sean pasados
        Assert.assertTrue(user.isDisplayed());
        Assert.assertTrue(password.isDisplayed());
    }

    @Test
    public void AssertFalse () throws InterruptedException {
        //El assert True se utiliza para realizar validacioneS para scripts negativos
        WebElement user = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("pass"));


        user.sendKeys("jnjose9625@gmail.com");
        password.sendKeys("asdasdasdas");
        password.submit();
        Thread.sleep(5000);
        WebElement mensaje = driver.findElement(By.xpath("//div[contains(text(), 'La contraseña que has ingresado es incorrecta')]"));

        //Se valida algun boton, mensaje de error, etiquetas para que nuestro test sea fallido
        Assert.assertFalse(mensaje.isDisplayed());
    }

    @Test
    public void AssertEquals () throws InterruptedException {
        //El Assert Equals realiza validaceiones de igualdad
        String expetedTitle = "Facebook - Entrar o registrarse";
        Thread.sleep(10000);
        Assert.assertEquals(expetedTitle, driver.getTitle());
    }

    @Test
    public void GetText ()
    {
        //Con los metodos GET, podemos recuperar informacion
        String messageFacebook = driver.findElement(By.xpath("//h2[contains(text(), 'Facebook te ayuda a comunicarte y compartir con las personas que forman parte de tu vida.')]")).getText();
        Assert.assertEquals(messageFacebook, "Aqui es el texto coorecto a validar");
    }

    @AfterTest
    public void tearDown ()
    {
        driver.quit();
    }

}