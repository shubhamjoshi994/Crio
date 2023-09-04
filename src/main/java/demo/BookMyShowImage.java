package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BookMyShowImage {

    WebDriver driver;

    public BookMyShowImage() {
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

    public void countImageUrl(){
        driver.get("https://in.bookmyshow.com/explore/home/chennai");

        WebElement recommendedMovies = driver.findElement(By.xpath("//div[@class='style__WidgetContainerWrapper-sc-lnhrs7-1 kNWDcM']"));

        int imageURL = recommendedMovies.findElements(By.tagName("img")).size();
        System.out.println("Total image URLs under recommended movies: " + imageURL);
    }
}
