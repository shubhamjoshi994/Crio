package demo;

import org.openqa.selenium.chrome.ChromeDriver;

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


}