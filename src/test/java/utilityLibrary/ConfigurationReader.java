package utilityLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    String filePath = "src/test/resources/configuration.properties";
     Properties prop;

    public ConfigurationReader(){
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

    public String setConfiguration(String key){
        return prop.getProperty(key);
    }

}
