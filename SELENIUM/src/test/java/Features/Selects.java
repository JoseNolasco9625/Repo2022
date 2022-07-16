package Features;

import Common.BaseTest;
import Elements.ElementsSelects;
import Utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Selects extends BaseTest
{
    SeleniumUtils utils = new SeleniumUtils();
    ElementsSelects elementsSelects = new ElementsSelects();

    @Test
    public void ListaConClicks () throws InterruptedException {
        utils.Click(elementsSelects.TapWoman(driver));

        utils.Click(elementsSelects.BottonMasTops(driver));

        utils.Click(elementsSelects.BottonTSshirts(driver));

        //****Seleccionar OPCIONES DE LISTAS CON CLICS********
        //No se recomienda utilizar dar clics en las opciones de un select
        utils.Click(elementsSelects.SelectSort(driver));
        utils.wating(driver, 3000);
        String opcionEsperada = "In stock";
        String opcionBuscar = String.format("//option[text()='%s']", opcionEsperada);
        WebElement option = driver.findElement(By.xpath(opcionBuscar));
        utils.Click(option);
        utils.wating(driver, 3000);
    }

    @Test
    public void ListaConSendKeys () throws InterruptedException
    {
        utils.Click(elementsSelects.TapWoman(driver));
        utils.wating(driver, 2000);
        utils.Click(elementsSelects.BottonMasTops(driver));
        utils.wating(driver, 2000);
        utils.Click(elementsSelects.BottonTSshirts(driver));
        utils.wating(driver, 2000);

        //******Manejo de listas con send keys*******+
        //************Esta opcion es recomendable**********
        String opcionEsperada = "In stock";
        elementsSelects.SelectSort(driver).sendKeys(opcionEsperada);
        utils.wating(driver, 3000);

    }

    @Test
    public void ListaUsandoClaseSelect() throws InterruptedException
    {
        utils.Click(elementsSelects.TapWoman(driver));
        utils.wating(driver, 2000);
        utils.Click(elementsSelects.BottonMasTops(driver));
        utils.wating(driver, 2000);
        utils.Click(elementsSelects.BottonTSshirts(driver));
        utils.wating(driver, 2000);

        //****************   Manejo de listas con clase Select **********
        //****Esta opcion es la mas recomendable*******
        //selectByVisibleText
        String opcionEsperada = "In stock";
        elementsSelects.SelectSort(driver);
        Select selectLista = new Select(elementsSelects.SelectSort(driver));
        //selectLista.selectByVisibleText(opcionEsperada);
        //selectLista.selectByValue("quantity:desc");
        selectLista.selectByIndex(6);
        utils.wating(driver, 3000);
    }

}
