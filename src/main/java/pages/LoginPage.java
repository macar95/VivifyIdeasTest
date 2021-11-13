package pages;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class LoginPage extends BasePage{

        @FindBy (xpath = "//input[@id = \"email\"]")
        WebElement emailField;

        @FindBy (xpath = "//input[@id = \"password\"]")
        WebElement passwordField;

        @FindBy (xpath = "//button[@class=\"btn btn-custom\"]")
        WebElement submitButton;

        @FindBy (xpath = "//a[@class=\"nav-link nav-buttons router-link-exact-active router-link-active\"]")
        WebElement loginButton;

        @FindBy (xpath = "//a[@class=\"nav-link nav-buttons\"]")
        WebElement registerButton;

         @FindBy (xpath = "//p[@class=\"alert alert-danger\"]")
         WebElement errorMessageContainer;



    ChromeDriver driver = null;
    public LoginPage (ChromeDriver driver) {
        driver.get("https://gallery-app.vivifyideas.com/login");
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public LoginPage enterEmail(String USERNAME) {
        emailField.sendKeys(USERNAME);
        return this;
    }

    public LoginPage enterPassword (String PASSWORD) {
        passwordField.sendKeys(PASSWORD);
        return this;
    }

    public HomePage clickSubmitButtonSuccess() {
        loginButton.click();
        return new HomePage(driver);
    }

    public LoginPage clickSubmitButtonFailure() {
        loginButton.click();
        return this;
    }

    public String getErrorMessage() {
        String errorMessage = errorMessageContainer.getText();
        return errorMessage;
    }


}
