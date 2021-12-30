package testCase;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;
import pageObjects.AllLinks;


import java.time.Duration;
import static commonFunction.CommonFunctions.driver;
import static commonFunction.CommonFunctions.properties;

public interface verifyalerts
{
    static Logger logger= Logger.getLogger(verifyAllLinks.class);
    public static void checkAlerts(){
        PageFactory.initElements(driver, AllLinks.class);
        PropertyConfigurator.configure("Log4j.properties");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(properties.getProperty("alertsUrl"));

            AllLinks.alertButton.click();
            Alert alert=driver.switchTo().alert();
            logger.info(alert.getText() +"  Click 'ok'");
            alert.accept();
            AllLinks.alertButton.click();
            logger.info(alert.getText() +"Click 'cancel'");
            alert.dismiss();
    }
}