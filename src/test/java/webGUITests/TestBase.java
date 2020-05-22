package webGUITests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import pageModel.*;
import utilities.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;

    public static GoogleHomepage googleHomepage;
    public static TheInternetHomepage theInternetHomepage;
    public static TheInternetFileUploadPage theInternetFileUploadPage;
    public static TheInternetDynamicLoadingPage theInternetDynamicLoadingPage;

    public ExtentReports extent = ExtentRepoManager.getInstance();
    public static ExtentTest test;

    @BeforeSuite
    public void startDriver() {
        System.setProperty(Util.DRIVER_TYPE, Util.DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Util.WAIT_TIME, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @BeforeTest
    public void goToWebsite(){
        googleHomepage = new GoogleHomepage(driver);
        theInternetHomepage = new TheInternetHomepage(driver);
        theInternetFileUploadPage = new TheInternetFileUploadPage(driver);
        theInternetDynamicLoadingPage = new TheInternetDynamicLoadingPage(driver);
    }

    @AfterMethod
    public void takeScreenshotOnFailure(ITestResult result) throws IOException {

        // Take Screenshot on Failure & log the failure in extent report
        if(ITestResult.FAILURE == result.getStatus()){

            Util.takeScreenshot(driver,Util.ssPath);
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
            test.fail("Test Case Failed Screenshot is below ").addScreenCaptureFromPath(Util.ssPath);
        }
        // Log the Success in extent report
        else if(result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
        }
        // Log the skip in extent report
        else {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
        }
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
        extent.flush();
    }
}
