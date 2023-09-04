package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BookMyShow {

    WebDriver driver;

    public BookMyShow() {
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

    public void countLinkOnHomePage(){
        driver.get("https://in.bookmyshow.com/explore/home/mumbai");
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        int size = allLinks.size();
        System.out.println("The total count of Link on the home Page is : " + size);

    }
}
