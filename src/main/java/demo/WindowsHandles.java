package demo;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowsHandles {

    WebDriver driver;

    public WindowsHandles() {
        System.out.println("Constructor: TestCases");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void testingWindowHandles() throws IOException {
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
        driver.switchTo().frame(driver.findElement(By.id("iframeResult")));

        WebElement tryItButton = driver.findElement(By.xpath("//button[@onclick='myFunction()']"));
        String primaryWindowHandle = driver.getWindowHandle();

        tryItButton.click();

        driver.switchTo().defaultContent();
        Set<String> allWindowHandles = driver.getWindowHandles();

        for( String WindowHandles :  allWindowHandles){
            if (!WindowHandles.equals(primaryWindowHandle)){
                driver.switchTo().window(WindowHandles);
            }
        }

        String title = driver.getTitle();
        System.out.println("The title of the new window is " + title);

        String url = driver.getCurrentUrl();
        System.out.println("The URL of the new window is: " + url);

        TakesScreenshot src = (TakesScreenshot) driver;
        File sourcePath = src.getScreenshotAs(OutputType.FILE);
        File destinationPath = new File("screenshots\\demofile.png");
        FileUtils.copyFile(sourcePath ,destinationPath);

        driver.close();
        driver.switchTo().window(primaryWindowHandle);

    }
}
