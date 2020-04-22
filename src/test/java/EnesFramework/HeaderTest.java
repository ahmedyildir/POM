package EnesFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import reportGenerator.ExtentTestManager;
import utilityLibrary.SetUpTest;

public class HeaderTest extends SetUpTest {
    //We set up super class with extend, place our driver and all the tools we need in super class so we can call them from any other class.


    @Test(enabled = true)
    public void EP_1001() {
        ExtentTestManager.startTest("EP_1001", "Testing for EP_1001");
        HP.verifyHomePage();
        HP.clickNewReleasesLink();
        util.wait(3);
        NRP.verifyNewReleasesPage();
    }

    @Test(enabled = true)
    public void EP_1002() {
        ExtentTestManager.startTest("EP_1002", "Testing for EP_1002");
        HP.verifyHomePage();
        util.moveMouseByElement(util.findElement(locator.getLocator("tryPrime")));
        util.click(util.findElement(locator.getLocator("getStarted")));
        util.wait(3);
        HP.verifySignInPage();
    }

    @Test (enabled = true)
    public void EP_1003() {
        ExtentTestManager.startTest("EP_1003", "Testing for EP_1003");

        HP.verifyHomePage();

        WebElement signIn = driver.findElement(By.id("nav-link-accountList"));
        util.moveMouseByElement(signIn);
        util.wait(3);
        String signInButton = util.getText(driver.findElement(By.xpath("//span[@class='nav-action-inner']")));
        Assert.assertTrue(signInButton.equals("Sign in"), "Could Not locate Sign in button!");
        driver.findElement(By.xpath("//span[contains(text(), 'Baby Registry')]")).click();
        util.wait(3);
        String babyRegistry = util.getText(driver.findElement(By.xpath("//span[@id='a-autoid-4']/*/*/*"))).trim();
        Assert.assertEquals(babyRegistry, "Create a new Baby Registry");
        util.wait(3);
        util.moveMouseByElement(signIn);
        util.wait(3);
        String signInButton2 = util.getText(driver.findElement(By.xpath("//span[@class='nav-action-inner']")));
        Assert.assertTrue(signInButton2.equals("Sign in"), "Could Not locate Sign in button for the second try!");
        driver.findElement(By.xpath("//span[contains(text(), 'Your Pets')]")).click();

        HP.verifySignInPage();


    }

    @Test (enabled = true)
    public void EP_1004(){
        ExtentTestManager.startTest("EP_1004", "Testing for EP_1004");

        HP.verifyHomePage();
        HP.clickNewReleasesLink();
        util.wait(3);
        NRP.verifyNewReleasesPage();
        util.wait(3);
        NRP.selectBabyFromLeftNavigationBar();

    }

    @Test (enabled = true)
    public void EP_1005(){
        ExtentTestManager.startTest("EP_1005", "Testing for EP_1005");

        HP.verifyHomePage();
        HP.fillSearchBox("camera");
        util.wait(3);
        HP.clickSearchButton();
        PLP.verifyProductPage();
        PLP.verifyCorrectProduct("camera");
        util.wait(3);
        for (String temp: PLP.getProductName()){
            if (temp.toLowerCase().contains("camera")){
                System.out.println(temp);
            }else {
                Assert.fail("Product Name doesn't contain camera: " + temp);
            }
        }
    }

    @Test (enabled = true)
    public void EP_1006(){
        ExtentTestManager.startTest("EP_1006", "Testing for EP_1006");

        HP.verifyHomePage();
        HP.fillSearchBox("Nintendo Switch");
        HP.clickSearchButton();
        PLP.verifyProductPage();
        PLP.verifyCorrectProduct("Nintendo Switch");
        util.click(driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-fixed-height'])[1]")));
        util.click(driver.findElement(By.id("add-to-cart-button-ubb")));
        util.wait(3);
        util.click(driver.findElement(By.id("nav-cart")));
        Assert.assertEquals(util.getText(driver.findElement(By.id("nav-cart-count"))),"1", "User Could NOT add the item to the cart!");
        util.isDisplayed(driver.findElement(By.xpath("//div[@class='sc-list-item-content']")), "Could NOT find the added item in the cart!");
    }



}

//Tests will run in alphabetic order
