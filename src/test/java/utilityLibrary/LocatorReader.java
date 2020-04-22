package utilityLibrary;

import org.openqa.selenium.By;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LocatorReader extends SetUpTest {

    String filePath = "src/test/resources/locator.properties";
    Properties prop;

    public LocatorReader(){
        try {
            prop = new Properties();
            FileInputStream file = new FileInputStream(filePath);
            prop.load(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public By getLocator(String key){
        String value = prop.getProperty(key);
        String newValue = value.split(":")[0].toLowerCase();
        String locater = value.split(":")[1];
        By by = null;

        switch (newValue){
            case "xpath" :
                by = By.xpath(locater);
                break;
            case "id" :
                by = By.id(locater);
                break;
            case "name" :
                by = By.name(locater);
                break;
            case "classname" :
                by = By.className(locater);
                break;
            case "cssselector" :
                by = By.cssSelector(locater);
                break;
            case "linktext" :
                by = By.linkText(locater);
                break;
            case "partiallinktext" :
                by = By.partialLinkText(locater);
                break;
            case "tagname" :
                by = By.tagName(locater);
                break;
            default:
                System.out.println("no locator found");
        }
        return by;

    }



}
