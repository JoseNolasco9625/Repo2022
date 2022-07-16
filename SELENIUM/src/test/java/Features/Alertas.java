package Features;

import Common.BaseTest;
import Utils.SeleniumUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Alertas extends BaseTest
{
    WebDriverWait wait;
    SeleniumUtils utils = new SeleniumUtils();


    @Test
    public void Alerts() throws InterruptedException
    {
        //INSTANCIA DE OBJETO JAVA SCRIPT
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("alert('EL EDHER ES GAY Y LE VA AL AMERICA');");
        wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.alertIsPresent());
        utils.wating(driver, 3000);
        //driver.switchTo().alert().accept();
        //utils.wating(driver, 3000);

        //Dismis Alerta --> lo que hace esta funcion es cancelar una alerta
        String alert = driver.switchTo().alert().getText();
        System.out.println("Texto de alerta" + alert);
        driver.switchTo().alert().dismiss();

    }
}
