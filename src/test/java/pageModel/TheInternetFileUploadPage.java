package pageModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TheInternetFileUploadPage extends pageBase {
    public TheInternetFileUploadPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "file-upload")
    WebElement chooseFileBTN;

    @FindBy(id = "file-submit")
    WebElement uploadBTN;

    public void uploadImage(String imagePath){
        chooseFileBTN.sendKeys(imagePath);
        uploadBTN.click();
    }
}
