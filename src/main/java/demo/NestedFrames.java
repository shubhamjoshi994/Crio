package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class NestedFrames {

    WebDriver driver;

    public NestedFrames() {
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

    public void nestedFrames(){
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        driver.switchTo().frame(driver.findElement(By.name("frame-top")));

        driver.switchTo().frame(driver.findElement(By.name("frame-left")));
        String text1 = driver.findElement(By.xpath("//body")).getText();
        System.out.println("Text inside Top Left Frame: " + text1);
        driver.switchTo().parentFrame();

        driver.switchTo().frame(driver.findElement(By.name("frame-middle")));
        String text2 = driver.findElement(By.xpath("//body")).getText();
        System.out.println("Text inside Top Middle Frame: " + text2);
        driver.switchTo().parentFrame();

        driver.switchTo().frame(driver.findElement(By.name("frame-right")));
        String text3 = driver.findElement(By.xpath("//body")).getText();
        System.out.println("Text inside Top Right Frame: " + text3);

        driver.switchTo().defaultContent();

        driver.switchTo().frame(driver.findElement(By.name("frame-bottom")));
        String text4 = driver.findElement(By.xpath("//body")).getText();
        System.out.println("Text inside Bottom Frame: " + text4);

        driver.switchTo().defaultContent();
    }
}
