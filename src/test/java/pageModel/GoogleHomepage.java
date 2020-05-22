package pageModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleHomepage extends pageBase{

    public GoogleHomepage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@name='q']")
    WebElement searchBar;

    public void searchForText(String text){
        searchBar.sendKeys(text);
        searchBar.submit();
    }
}
