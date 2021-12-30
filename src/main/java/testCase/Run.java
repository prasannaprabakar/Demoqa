package testCase;

import commonFunction.CommonFunctions;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.IOException;

public class Run extends CommonFunctions implements verifyAllLinks, verifyCheckBox
{
    static Logger logger=Logger.getLogger(Run.class);
    public static void main(String[] args) throws IOException
    {
        PropertyConfigurator.configure("Log4j.properties");
        launchBrowser();
        logger.info("number of links in the page = "+ verifyAllLinks.getLinkCount());
        logger.info(verifyAllLinks.getAllLinkText());
        verifyCheckBox.handleCheckBox();
        verifyalerts.checkAlerts();
        close();
    }
}
