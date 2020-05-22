package webGUITests;


import data.ExcelReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Tests extends TestBase{

    @DataProvider(name = "ImagesData")
    public Object[][] userLoginData() throws IOException {
        //Get data from ExcelReader Class
        ExcelReader ER = new ExcelReader();

        return ER.getImageData();
    }

    @Test(priority = 1)
    public void searchForText(){
        test = extent.createTest("Google search Assertion");

        driver.get("https://www.google.com/ncr");
        googleHomepage.searchForText("selenium webdriver");

        /*List all the links to other pages in search results*/
        List link = driver.findElements(By.xpath("//*[@id='rso']/div/div/div/a"));

        /*Get the text from the third link and assert on it*/
        WebElement thirdLink = (WebElement) link.get(2);
        Assert.assertTrue(thirdLink.getText().contains("What is Selenium WebDriver?"));
    }

    @Test(priority = 2, dataProvider = "ImagesData")
    public void uploadImage(String path){
        test = extent.createTest("Uploading Image");

        driver.get("https://the-internet.herokuapp.com/");
        theInternetHomepage.goToFileUploadPage();
        theInternetFileUploadPage.uploadImage(path);

        /*Get the image name only without the whole path*/
        File imageName = new File(path);

        /*Assert that the image is uploaded with the correct name*/
        WebElement uploadedImage = driver.findElement(By.id("uploaded-files"));
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(uploadedImage.isDisplayed());
        sa.assertEquals(uploadedImage.getText(),imageName.getName());
        sa.assertAll();
    }

    @Test(priority = 3)
    public void dynamicLoading(){

        test = extent.createTest("Dynamic Loading Webpage");

        driver.get("https://the-internet.herokuapp.com/");
        theInternetHomepage.goTodynamicloadingPage();
        theInternetDynamicLoadingPage.startDynamicLoading();

        /*Assert that the text displayed is "Hello World!" */
        String text = driver.findElement(By.id("finish")).getText();
        Assert.assertTrue(text.contains("Hello World!"));
    }
}
