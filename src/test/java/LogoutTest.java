import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import pages.HomePage;
import pages.LoginPage;
import pages.Strings;

import static pages.Strings.HOMEPAGE_URL;
import static pages.Strings.*;

public class LogoutTest extends BaseTest{

    /**
     * Test - Successful logout
     * Steps:
     * 1. Navigate to vivixy idea site
     * 2. Log in
     * 3. Click Logout button
     *
     * Expected result:
     * 4.Verify that user is logged out
     */

    @Test
    public void logOut() {

        ChromeDriver driver = openChromeDriver();
        try {
            driver.get(HOMEPAGE_URL);

            LoginPage loginPage = new LoginPage(driver);
            loginPage.enterEmail(Strings.VALID_USER_NAME);
            loginPage.enterPassword(Strings.VALID_PASSWORD);

            WebElement submitButton = driver.findElement(By.xpath("//button[@class=\"btn btn-custom\"]"));
            Actions actions = new Actions(driver);
            actions.moveToElement(submitButton).click().build().perform();
            sleep();

            WebElement logoutButton = driver.findElement(By.xpath("//a[@role=\"button \"]"));
            logoutButton.click();
            sleep();
            String currentPageURL = driver.getCurrentUrl();
            assert currentPageURL.equals(LOGIN_URL): "Error. You are not logged in. Expected: " + LOGIN_URL + ". Actual: " + currentPageURL;
        }
        finally {
            driver.quit();
        }

    }

}
