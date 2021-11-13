package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public final class CreateGalleryPage extends HomePage{

    @FindBy(id = "title")
     WebElement titleField;

    @FindBy(id = "description")
     WebElement descriptionField;

    @FindBy(xpath = "//input[@type=\"url\"]")
     WebElement imgField;

    @FindBy(xpath = "//i[@class=\"fas fa-chevron-circle-up\"]")
     WebElement arrowUpButton;

    @FindBy(xpath = "//i[@class=\"fas fa-chevron-circle-down\"]")
     WebElement arrowDownButton;

    @FindBy(xpath = "/html/body/div/div[2]/div/div/form/div[3]/button")
     WebElement addImageButton;

    @FindBy(xpath = "/html/body/div/div[2]/div/div/form/button[1]")
     WebElement submitButton;

    @FindBy(xpath = "/html/body/div/div[2]/div/div/form/button[2]")
     WebElement cancelButton;

    public CreateGalleryPage enterTitle(String TITLE) {
        titleField.sendKeys(TITLE);
        return this;
    }

    public CreateGalleryPage enterDescription(String DESCRIPTION) {
        titleField.sendKeys(DESCRIPTION);
        return this;
    }

    public CreateGalleryPage imageUrl1(String FIRST_IMAGE_URL) {
        imgField.sendKeys(FIRST_IMAGE_URL);
        return this;
    }

public CreateGalleryPage imageUrl2(String SECOND_IMAGE_URL) {
        imgField.sendKeys(SECOND_IMAGE_URL);
        return this;
    }






    public CreateGalleryPage(ChromeDriver driver) {
        super(driver);
    }
}
