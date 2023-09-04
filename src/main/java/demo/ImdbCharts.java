package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ImdbCharts {

    WebDriver driver;

    public ImdbCharts() {
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
    public void imdbChartRatings() throws InterruptedException {
        try {

            driver.get("https://www.imdb.com/chart/top/");

            Select select = new Select(driver.findElement(By.id("sort-by-selector")));
            select.selectByVisibleText("IMDb rating");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='IMDb rating']")));

            WebElement movieList = driver.findElement(By.xpath("//ul[contains(@class,'ipc-metadata-list')]"));
            String highestRatedMovie = movieList.findElement(By.xpath(".//a[@class='ipc-title-link-wrapper']/h3")).getText();
            System.out.println("Highest Rated Movie: " + highestRatedMovie);

//            WebElement movieList1 = driver.findElement(By.xpath("//ul[contains(@class,'ipc-metadata-list')]"));
            int totalMoviesOnList = driver.findElements(By.xpath("//li[@class='ipc-metadata-list-summary-item sc-bca49391-0 eypSaE cli-parent']")).size();
            System.out.println("Total number of movies in List " + totalMoviesOnList);

            select.selectByVisibleText("Release date");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Release date']")));

            WebElement sortButton = driver.findElement(By.id("swap-sort-order-button"));
            sortButton.click();

            Thread.sleep(1500);
            WebElement movieList3 = driver.findElement(By.xpath("//ul[contains(@class,'ipc-metadata-list')]"));
            String oldestMovie = movieList3.findElement(By.xpath("//a[@class='ipc-title-link-wrapper']/h3")).getText();
            System.out.println("Oldest movie on the List is: " + oldestMovie);

            sortButton.click();

            Thread.sleep(1500);
            WebElement movieList4 = driver.findElement(By.xpath("//ul[contains(@class,'ipc-metadata-list')]"));
            String newestMovie = movieList4.findElement(By.xpath("//a[@class='ipc-title-link-wrapper']/h3")).getText();
            System.out.println("Oldest movie on the List is: " + newestMovie);

            select.selectByVisibleText("Number of ratings");
            Thread.sleep(1500);
            WebElement movieList5= driver.findElement(By.xpath("//ul[contains(@class,'ipc-metadata-list')]"));
            String mostUserRating = movieList5.findElement(By.xpath("//a[@class='ipc-title-link-wrapper']/h3")).getText();
            System.out.println("Oldest movie on the List is: " + mostUserRating);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
