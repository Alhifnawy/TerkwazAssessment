package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Util {

    //Specify the driver to be chrome driver
    public static final String DRIVER_TYPE = "webdriver.chrome.driver";

    //Specify the chrome driver location
    public static final String DRIVER_PATH = "src/test/resources/chromedriver.exe";

    // Time to wait when searching for a GUI element
    public static final int WAIT_TIME = 30;

    // Define the screenshot location, replace any ":" with "-" & replace any " " with "_" to be formatted correctly
    public static String ssPath = System.getProperty("user.dir")+"/Screenshot/"+System.currentTimeMillis()+".png";

    //Method to take a screenshot
    public static void takeScreenshot(WebDriver driver, String filePath) throws IOException {
        // Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot = (TakesScreenshot)driver;

        // Call getScreenshotAs method to create image file
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

        // Move image file to new destination
        File DestFile = new File(filePath);

        // Copy file at destination
        FileUtils.copyFile(SrcFile, DestFile);
    }
}
