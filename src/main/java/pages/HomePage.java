package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(xpath = "//a[@class=\"navbar-brand router-link-exact-active router-link-active\"]")
    WebElement galleryAppButton;

    @FindBy(xpath = "//a[@class=\"nav-link nav-buttons router-link-exact-active router-link-active\"]")
    WebElement allGaleriesButton;

    @FindBy(xpath = "//a[@href=\"/my-galleries\"]")
    WebElement myGalleriesButton;

    @FindBy(xpath = "//a[@href=\"/create\"]")
    WebElement createGalleryButton;

    @FindBy(xpath = "//a[@role=\"button \"]")
    WebElement logoutButton;

    @FindBy(xpath = "//input[@type=\"text\"]")
    WebElement searchBoxField;

    @FindBy(xpath = "//button[@class=\"btn btn-outline-secondary input-button\"]")
    WebElement filterButton;

    @FindBy(xpath = "//button[@class=\"btn btn-custom\"]")
    WebElement loadMoreButton;






    public HomePage(ChromeDriver driver) {
        super(driver);
    }
}
