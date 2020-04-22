package amazonPage;

import org.openqa.selenium.By;
import org.testng.Assert;
import utilityLibrary.SetUpTest;

public class NewReleasePage extends SetUpTest {

    public void verifyNewReleasesPage(){
        String newReleasePage = util.getText(driver.findElement(By.id("zg_banner_text_wrapper")));
        Assert.assertTrue(newReleasePage.equals("Amazon Hot New Releases"), "****User has NOT land on New Releases Page!*** Actual: " + newReleasePage);
    }

    public void selectBabyFromLeftNavigationBar(){

        driver.findElement(By.xpath("//li/a[text() = 'Baby']")).click();
        String babyPage = util.getText(driver.findElement(By.xpath("//span[@class='category']")));
        Assert.assertTrue(babyPage.equals("Baby"), "User NOT landed on New Releases in Baby Page!");

    }

}
