package utilityLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Utility {

    public static WebDriver driver;

    public Utility(WebDriver driver) { this.driver = driver; }
    //This.driver -> Driver which is located in this class, driver-> Driver comes from another class.
    //We need to pass the driver which our tests might use


    //Utility Methods

    public void moveMouseByElement(WebElement element){
        Actions myAction = new Actions(driver);
        myAction.moveToElement(element).build().perform();
    }

    public void wait(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void selectByIndex(WebElement element, int index){
        Select mySelect = new Select(element);
        mySelect.selectByIndex(index);
    }

    public String getText(WebElement element){
        return element.getText();
    }

    public void fill(WebElement element, String text) {
        try{
        element.sendKeys(text);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void click(WebElement element) {
        element.click();
    }

    public void isDisplayed(WebElement element, String message){
         Assert.assertTrue(element.isDisplayed(), message);
    }

    public WebElement findElement(By by){
        WebElement returnElement = driver.findElement(by);
        return returnElement;
    }

}
