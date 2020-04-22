package utilityLibrary;

import amazonPage.HeaderPage;
import amazonPage.NewReleasePage;
import amazonPage.ProductListPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SetUpTest {
    public static WebDriver driver;
    public static Utility util; //= new Utility(); We move that to after assigning the driver.
                                //So we don't get null point exception for driver.
    public static HeaderPage HP;
    public static NewReleasePage NRP;
    public static ProductListPage PLP;
    public static ConfigurationReader config; //We will use this only in this class so we dont need public static
    public static LocatorReader locator; //We will use this for all project so we need public static


    //Test Set Up

    @BeforeMethod //TestNG will run this method before any testing method
    public void startTest(){
        String driverPath = "src/test/resources/chromedriver";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        locator = new LocatorReader();
        util = new Utility(driver);
        PLP = new ProductListPage();
        NRP = new NewReleasePage();
        HP = new HeaderPage();
        config = new ConfigurationReader();
        driver.get(config.setConfiguration("Url"));
        driver.manage().window().fullscreen();

    }

    //Test End

    @AfterMethod
    //TestNG will run this method after any testing method, It will run this method doesnt mather if test failed!
    public void endTest(){
        util.wait(3);
        driver.close();
        driver.quit();
    }






}
