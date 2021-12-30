package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class AllLinks
{

    @FindBy(xpath = "//div[@id='linkWrapper']//following-sibling::a")
    public static List<WebElement>allLinks;
    @FindBy(xpath = "//input[@type='checkbox']//following-sibling::span[@class='rct-checkbox']")
    public static List<WebElement> checkBox;
    @FindBy(xpath = "//span[@class='rct-title']")
    public static List<WebElement> checkBoxText;
    @FindBy(xpath = "//button[@id='confirmButton']")
    public static WebElement alertButton;
}
