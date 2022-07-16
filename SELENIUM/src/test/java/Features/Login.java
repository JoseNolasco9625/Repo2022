package Features;

import Common.Config;
import Elements.ElementsLogin;
import Utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login
{
    private WebDriver driver;
    ElementsLogin elementsLogin = new ElementsLogin();
    SeleniumUtils utils = new SeleniumUtils();

    public void miLogin (WebDriver driver) throws InterruptedException
    {
        // Hacer click en botón SingIN
        //elementsLogin.ButtonSingIn(driver).click();
        utils.Click(elementsLogin.ButtonSingIn(driver));
        Thread.sleep(2000);

        //Esto sirve para desplazarse
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy (0,350)");
        Thread.sleep(2000);

        //Hacer click en Input Email
        /*WebElement Email = driver.findElement(By.cssSelector("input[id='email']"));
        Email.click();
        Email.clear();
        Email.sendKeys(Config.user);*/
        utils.InputFill(elementsLogin.InputUser(driver), Config.user);

        //Hacer click en Input Pass
        /*WebElement Pass = driver.findElement(By.cssSelector("input[id='passwd']"));
        Pass.click();
        Pass.clear();
        Pass.sendKeys(Config.pwd);*/
        utils.InputFill(elementsLogin.InputPass(driver), Config.pwd);
        Thread.sleep(2000);

        //Hacer click en el botón SingIn
        /*WebElement Log = driver.findElement(By.cssSelector("button[id='SubmitLogin']"));
        Log.click();*/
        utils.Click(elementsLogin.BottonSingIn(driver));
        Thread.sleep(2000);

    }
}
