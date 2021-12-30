package testCase;

import commonFunction.CommonFunctions;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pageObjects.AllLinks;
import static commonFunction.CommonFunctions.driver;
import static commonFunction.CommonFunctions.properties;

interface verifyCheckBox
{
    static Logger logger=Logger.getLogger(verifyCheckBox.class);
    public static void handleCheckBox(){
    PageFactory.initElements(driver, AllLinks.class);
    PropertyConfigurator.configure("Log4j.properties");
    driver.get(properties.getProperty("checkBoxUrl"));
    driver.findElement(By.xpath("//button[@class='rct-option rct-option-expand-all']")).click();
    for (int index=0;index<AllLinks.checkBox.size();index++){
        WebElement temp=AllLinks.checkBox.get(index);
        String text=AllLinks.checkBoxText.get(index).getText();
        if (temp.isSelected()){
            logger.info(text+" selected");
        }
        else{
            logger.info(text+" not selected");
        }
    }
}

}
