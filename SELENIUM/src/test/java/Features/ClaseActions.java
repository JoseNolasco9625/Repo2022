package Features;

import Common.BaseTestDos;
import Elements.ElementsAmazon;
import Utils.SeleniumUtils;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ClaseActions extends BaseTestDos
{
    SeleniumUtils utils = new SeleniumUtils();
    ElementsAmazon elementsAmazon = new ElementsAmazon();

    @Test
    public void MoveToElement () throws InterruptedException
    {
        //Codigo es para mover el mouse
        Actions action = new Actions(driver);
        action.moveToElement(elementsAmazon.MenuPrime(driver)).build().perform();
        utils.wating(driver, 4000);

        action.moveToElement(elementsAmazon.BotonAmazonPrime(driver)).build().perform();
        utils.wating(driver, 2000);
        action.click().build().perform();
        utils.wating(driver, 4000);

    }
}
