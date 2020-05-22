package pageModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TheInternetDynamicLoadingPage extends pageBase {
    public TheInternetDynamicLoadingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Example 2: Element rendered after the fact")
    WebElement example2BTN;

    @FindBy(xpath = "//*/div[2]/div/div/div/button")
    WebElement startBTN;

    public void startDynamicLoading(){
        example2BTN.click();
        startBTN.click();
    }
}
