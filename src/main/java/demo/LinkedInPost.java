package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LinkedInPost {

    WebDriver driver;

    public LinkedInPost() {
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

    public void createPost(){
        driver.get("https://in.linkedin.com/");
        WebElement username = driver.findElement(By.id("username"));
        username.clear();
        username.sendKeys("");

        WebElement password = driver.findElement(By.id("password"));
        password.clear();
        password.sendKeys("");

        WebElement signIn = driver.findElement(By.xpath("//button[text()='Sign in']"));
        signIn.click();

        String viewCount = driver.findElement(By.xpath("//a[@href='/me/profile-views/']//strong")).getText();
        System.out.println("The number of people who viewed my profile is: " + viewCount);

        String impressionCount = driver.findElement(By.xpath("//a[contains(@href,'recent-activity/shares/')]//strong")).getText();
        System.out.println("The number of impression of my profile is: " + impressionCount);



    }
}
