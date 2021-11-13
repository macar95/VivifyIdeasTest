import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;
import pages.HomePage;

import java.time.Duration;

import static pages.Strings.*;

public class LoginTest extends BaseTest{

    /**
     * Test - Successful login with valid credentials
     * Steps:
     * 1. Navigate to vivixy idea site
     * 2. enter valid e-mail
     * 3. enter valid password
     * 4. click submit button
     *
     * Expected result:
     * 4.Verify that user is logged in
     */

    @Test
    public void testSuccessfulLogIn()  {
        ChromeDriver driver = openChromeDriver();
        try{
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
        finally {
            driver.quit();
        }

    }

    /**
     * Test - Unsuccessful login with invalid credentials
     * Steps:
     * 1. Navigate to vivixy idea site
     * 2. enter invalid e-mail
     * 3. enter valid password
     * 4. click submit button
     *
     * Expected result:
     * 4.Verify that user is not logged in
     */

    @Test
    public void testUnsuccessfulLogIn1() {
        ChromeDriver driver = openChromeDriver();
        try {

            driver.get(HOMEPAGE_URL);

            LoginPage loginPage = new LoginPage(driver);
            loginPage.enterEmail(Strings.INVALID_USER_NAME);
            loginPage.enterPassword(Strings.VALID_PASSWORD);

            WebElement submitButton = driver.findElement(By.xpath("//button[@class=\"btn btn-custom\"]"));
            Actions actions = new Actions(driver);
            actions.moveToElement(submitButton).click().build().perform();

            String currentPageURL = driver.getCurrentUrl();
            assert currentPageURL.equals(LOGIN_URL): "Error. You are logged in. Expected: " + LOGIN_URL + ". Actual: " + currentPageURL;
        }
        finally {
            driver.quit();
        }

    }

    /**
     * Test - Unsuccessful login with invalid credentials
     * Steps:
     * 1. Navigate to vivixy idea site
     * 2. enter valid e-mail
     * 3. enter invalid password
     * 4. click submit button
     *
     * Expected result:
     * 4.Verify that user is not logged in
     */

    @Test
    public void testUnsuccessfulLogIn2() {
        ChromeDriver driver = openChromeDriver();
        try {
            driver.get(HOMEPAGE_URL);

            LoginPage loginPage = new LoginPage(driver);
            loginPage.enterEmail(Strings.VALID_USER_NAME);
            loginPage.enterPassword(INVALID_PASSWORD);

            WebElement submitButton = driver.findElement(By.xpath("//button[@class=\"btn btn-custom\"]"));
            Actions actions = new Actions(driver);
            actions.moveToElement(submitButton).click().build().perform();

            String currentPageURL = driver.getCurrentUrl();
            assert currentPageURL.equals(LOGIN_URL): "Error. You are logged in. Expected: " + LOGIN_URL + ". Actual: " + currentPageURL;
        }
        finally {
            driver.quit();
        }

    }

    /**
     * Test - Unsuccessful login with invalid credentials
     * Steps:
     * 1. Navigate to vivixy idea site
     * 2. enter invalid e-mail
     * 3. enter invalid password
     * 4. click submit button
     *
     * Expected result:
     * 4.Verify that user is not logged in
     */

    @Test
    public void testUnsuccessfulLogIn3() {
        ChromeDriver driver = openChromeDriver();
        try {
            driver.get(HOMEPAGE_URL);

            LoginPage loginPage = new LoginPage(driver);
            loginPage.enterEmail(Strings.INVALID_USER_NAME);
            loginPage.enterPassword(Strings.INVALID_PASSWORD);

            WebElement submitButton = driver.findElement(By.xpath("//button[@class=\"btn btn-custom\"]"));
            Actions actions = new Actions(driver);
            actions.moveToElement(submitButton).click().build().perform();

            String currentPageURL = driver.getCurrentUrl();
            assert currentPageURL.equals(LOGIN_URL): "Error. You are logged in. Expected: " + LOGIN_URL + ". Actual: " + currentPageURL;
        }
        finally {
            driver.quit();
        }
    }
}
