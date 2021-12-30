package commonFunction;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class CommonFunctions
{
    public static WebDriver driver=null;
    public static Properties properties=null;
    public static Properties loadPropertyFile() throws IOException
    {
        FileInputStream fileInputStream=new FileInputStream("config.properties");
        properties=new Properties();
        properties.load(fileInputStream);
        return properties;
    }

    public static void launchBrowser() throws IOException
    {
        loadPropertyFile();
        String browser=properties.getProperty("browser");
        String url=properties.getProperty("url");
        if (browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver= new ChromeDriver();

        }
        else if (browser.equalsIgnoreCase("fireFox")){
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
        }
        else if(browser.equalsIgnoreCase("InternetExplorer")){
            WebDriverManager.iedriver().setup();
            driver=new InternetExplorerDriver();
        }
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


    }
    public static void close(){
             driver.quit();
    }
}
