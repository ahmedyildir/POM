package amazonPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilityLibrary.SetUpTest;

public class HeaderPage extends SetUpTest {


    public static void main(String[] args) {

    }


    public void clickNewReleasesLink(){
        util.click(util.findElement(locator.getLocator("newReleaseLink")));
        util.wait(3);
    }

    public void verifyHomePage(){
        String homepageTitle = driver.getTitle();
        String expectedPageTitle = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
        if (homepageTitle.equals(expectedPageTitle)) {
            System.out.println("User has successfully land on Homepage!");
        }else{
            System.out.println("****User has NOT land on Homepage!***");
        }
    }

    public void verifySignInPage(){
        try {
            util.isDisplayed(driver.findElement(By.id("signInSubmit")), "***User NOT land on Sign In Page!***");
        }catch (Exception e){

        }
    }


    public void fillSearchBox(String text) {
        util.fill(util.findElement(locator.getLocator("searchBox")), text);
    }

    public void clickSearchButton(){
        WebElement searchButton = driver.findElement(By.xpath("//input[@value='Go']"));
        util.click(searchButton);
    }
}
