package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Search_Amazon {

    WebDriver driver;

    public Search_Amazon() {
        System.out.println("Constructor: TestCases");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void searchAmazon(){

        driver.get("https://www.google.com/");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.clear();
        searchBox.sendKeys("amazon");
        searchBox.sendKeys(Keys.RETURN);
        boolean result = driver.findElement(By.xpath("//span[text()='Amazon.com' or text()='Amazon.in']")).isDisplayed();
        System.out.println("Amazon.com or Amazon.in is displayed after Google Search? " + result);

    }
}
