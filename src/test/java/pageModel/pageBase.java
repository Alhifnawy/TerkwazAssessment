package pageModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class pageBase {

    protected WebDriver driver;

    public pageBase(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
