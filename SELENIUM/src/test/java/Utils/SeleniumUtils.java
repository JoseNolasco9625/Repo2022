package Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.function.Function;

public class SeleniumUtils
{
    WebDriver driver;
    protected WebElement element;

    public void Click (WebElement element)
    {
        element.click();
    }

    public void Clear (WebElement element)
    {
        element.clear();
    }

    public void InputFill (WebElement input, String data)
    {
        Clear(input);
        input.sendKeys(data);
    }

    public void flu_waits (WebDriver driver, By elements)
    {
        Wait<WebDriver> fWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class);

        WebElement element = fWait.until(new Function<WebDriver, WebElement>()
                                         {
                                             public WebElement apply(WebDriver driver)
                                             {
                                                 return driver.findElement(elements);
                                             }
                                         }
        );
    }

    public void wating (WebDriver driver, int espera) throws InterruptedException
    {
        Thread.sleep(espera);
    }

    public void Enter ()
    {
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER);
    }

    public String getScreenshot(WebDriver driver, String screenshotName) throws Exception
    {
        //below line is just to append the date format with the screenshot name to avoid duplicate names
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        //after execution, you could see a folder "FailedTestsScreenshots" under src folder
        String destination = System.getProperty("user.dir") + "/Images/"+screenshotName+dateName+".png";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        //Returns the captured file path
        return destination;
    }

}

