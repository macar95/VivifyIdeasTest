import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import pages.HomePage;
import pages.LoginPage;
import pages.Strings;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static pages.Strings.*;
import static pages.Strings.SECOND_IMAGE_URL;

public class BaseTest {


    public ChromeDriver openChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(new String[]{"--start-maximized"});
        options.addArguments(new String[]{"--ignore-certificate-errors"});
        options.addArguments(new String[]{"--disable-popup-blocking"});
        options.addArguments(new String[]{"--incognito"});
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        ChromeDriver driver = new ChromeDriver(options);
        return driver;
    }

    public void logIn() {
        ChromeDriver driver = openChromeDriver();
        driver.get(HOMEPAGE_URL);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(Strings.VALID_USER_NAME);
        loginPage.enterPassword(Strings.VALID_PASSWORD);

        WebElement submitButton = driver.findElement(By.xpath("//button[@class=\"btn btn-custom\"]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(submitButton).click().build().perform();
        sleep();
        String currentPageURL = driver.getCurrentUrl();
        assert currentPageURL.equals(HOMEPAGE_URL): "Error. You are not logged in. Expected: " + HOMEPAGE_URL + ". Actual: " + currentPageURL;

    }

    public void createdGallery () {

        ChromeDriver driver = openChromeDriver();
            driver.get(HOMEPAGE_URL);

            LoginPage loginPage = new LoginPage(driver);
            loginPage.enterEmail(VALID_USER_NAME);
            loginPage.enterPassword(VALID_PASSWORD);

            WebElement submitButton = driver.findElement(By.xpath("//button[@class=\"btn btn-custom\"]"));
            Actions actions = new Actions(driver);
            actions.moveToElement(submitButton).click().build().perform();
            sleep();
            String currentPageURL = driver.getCurrentUrl();
            assert currentPageURL.equals(HOMEPAGE_URL): "Error. You are not logged in. Expected: " + HOMEPAGE_URL + ". Actual: " + currentPageURL;


            WebElement createGalleryButton = driver.findElement(By.xpath("//a[@href=\"/create\"]"));
            createGalleryButton.click();

            WebElement titleField = driver.findElement(By.id("title"));
            titleField.sendKeys("Naslov");

            WebElement descriptionField = driver.findElement(By.id("description"));
            descriptionField.sendKeys("Opis");

            WebElement imgUrl = driver.findElement(By.xpath("//input[@placeholder=\"image url\"]"));
            imgUrl.sendKeys(FIRST_IMAGE_URL);

            WebElement addImageButton = driver.findElement(By.xpath("//*[text() = \"Add image\"]"));
            addImageButton.click();

            WebElement imgUrl2 = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/div[3]/div[2]/div/input"));
            imgUrl2.sendKeys(SECOND_IMAGE_URL);

            WebElement submitButton2 = driver.findElement(By.xpath("//*[text() = \"Submit\"]"));
            submitButton2.click();

            String currentPageUrl = driver.getCurrentUrl();
            assert currentPageURL.equals(HOMEPAGE_URL): "Error. You are not on home page. Expected: " + HOMEPAGE_URL +
                    ". Actual: " + currentPageUrl;

            WebElement myGalleriesButton = driver.findElement(By.xpath("//a[@href=\"/my-galleries\"]"));
            myGalleriesButton.click();

            sleep();

        }



    ChromeDriver driver = null;



    public void sleep(){
        try{
            Thread.sleep(2000);

        } catch (Exception e) {}
    }

}
