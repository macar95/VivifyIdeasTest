package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class MyGalleriesPage extends BasePage{

    @FindBy(xpath = "//input[@type=\"text\"]")
    WebElement searchBoxField;

    @FindBy(xpath = "//button[@class=\"btn btn-outline-secondary input-button\"]")
    WebElement filterButton;




    public MyGalleriesPage(ChromeDriver driver) {
        super(driver);
    }
}
