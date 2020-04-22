package amazonPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilityLibrary.SetUpTest;

import java.util.ArrayList;
import java.util.List;

public class ProductListPage extends SetUpTest {


    public void verifyProductPage(){
        util.isDisplayed(driver.findElement(By.id("s-refinements")), "***Could Not Locate Product Page!***");
    }
    public void verifyCorrectProduct(String productName){
        String name = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']")).getText();
        String modifiedName = name.replaceAll("^\"|\"$", "");
        System.out.println(modifiedName);
        Assert.assertTrue(modifiedName.equals(productName), "***Wrong Product Page!***");
    }

    public List<String> getProductName(){
        List<WebElement> listOfProductNames = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        List<String> names = new ArrayList<String>();
        for (WebElement element: listOfProductNames) {
            names.add(element.getText());
        }

        return names;
    }



}
