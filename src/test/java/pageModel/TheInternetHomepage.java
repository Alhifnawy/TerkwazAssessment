package pageModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TheInternetHomepage extends pageBase {
    public TheInternetHomepage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@href='/upload']")
    WebElement fileUploadBTN;

    @FindBy(linkText = "Dynamic Loading")
    WebElement dynamicLoadingBTN;

    public void goToFileUploadPage(){
        fileUploadBTN.click();
    }

    public void goTodynamicloadingPage(){
        dynamicLoadingBTN.click();
    }
}
