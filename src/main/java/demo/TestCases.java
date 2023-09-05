package demo;

import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
//        System.out.println("Constructor: TestCases");
//        WebDriverManager.chromedriver().timeout(30).setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01(){
        Search_Amazon searchAmazon = new Search_Amazon();
        searchAmazon.searchAmazon();
        searchAmazon.endTest();
    }

    public  void testCase02(){
        BookMyShow bookMyShow = new BookMyShow();
        bookMyShow.countLinkOnHomePage();
        bookMyShow.endTest();
    }

    public  void testCase03(){
        LinkedInPost linkedInPost = new LinkedInPost();
        linkedInPost.createPost();
        linkedInPost.endTest();
    }

    public  void testCase04(){
        BookMyShowImage bookMyShowImage = new BookMyShowImage();
        bookMyShowImage.countImageUrl();
        bookMyShowImage.endTest();
    }

    public  void testCase05(){
        NestedFrames nestedFrames = new NestedFrames();
        nestedFrames.nestedFrames();
        nestedFrames.endTest();
    }

    public  void testCase06() throws InterruptedException {
        ImdbCharts imdbCharts = new ImdbCharts();
        imdbCharts.imdbChartRatings();
        imdbCharts.endTest();
    }

    public  void testCase07() throws InterruptedException, IOException {
        WindowsHandles windowsHandles = new WindowsHandles();
        windowsHandles.testingWindowHandles();
        windowsHandles.endTest();
    }


}
