package Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementsLogin
{
    public By buttonSingin = By.cssSelector("a[title='Log in to your customer account']");
    public WebElement ButtonSingIn (WebDriver driver)
    {
        WebElement buttonsingin = driver.findElement(buttonSingin);
        return buttonsingin;
    }

    public By inputUser = By.id("email");
    public WebElement InputUser (WebDriver driver)
    {
        WebElement inputuser = driver.findElement(inputUser);
        return inputuser;
    }

    public By inputPass = By.id("passwd");
    public WebElement InputPass (WebDriver driver)
    {
        WebElement inputpass = driver.findElement(inputPass);
        return inputpass;
    }

    public By bottonSingIn = By.id("SubmitLogin");
    public WebElement BottonSingIn (WebDriver driver)
    {
        WebElement bottonsingin = driver.findElement(bottonSingIn);
        return bottonsingin;
    }

    public By tapWomen = By.partialLinkText("Women");
    public WebElement TapWomen (WebDriver driver)
    {
        WebElement tapwomen = driver.findElement(tapWomen);
        return tapwomen;
    }

}
