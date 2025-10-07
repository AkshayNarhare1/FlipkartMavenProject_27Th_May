package BaseClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Base1 {

    static Properties properties;
    static WebDriver driver;


    // launch browser based on input string value "chrome", "firefox", "edge"
    public static WebDriver launchBrowser(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else {
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static WebDriver getDriver(){
        return driver;
    }



    // load config properties file
    public static void loadConfigProperties() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("config.properties");
        properties = new Properties();
        properties.load(fileInputStream);
    }

    // get property value by key
    public static String getPropertyValue(String key) {
        return properties.getProperty(key);
    }
}
