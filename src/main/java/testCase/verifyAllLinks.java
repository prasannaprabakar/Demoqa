package testCase;

import commonFunction.CommonFunctions;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pageObjects.AllLinks;

import java.util.ArrayList;
import java.util.List;

import static commonFunction.CommonFunctions.driver;

interface verifyAllLinks
{


   public static int getLinkCount(){
       PageFactory.initElements(driver, AllLinks.class);
       PropertyConfigurator.configure("Log4j.properties");
       int linkCount=AllLinks.allLinks.size();
       return linkCount;


   }

    public static List<String> getAllLinkText(){
        List<String>allLinkText=new ArrayList<>();
        for (int index=0;index<getLinkCount();index++){
           String temp= AllLinks.allLinks.get(index).getText();
          if(temp!=null&&temp.isEmpty()&&temp.isBlank()){
              allLinkText.add(AllLinks.allLinks.get(index).getAttribute("href"));
              continue;
          }
            allLinkText.add(temp);
           }

     return allLinkText;
    }

}
