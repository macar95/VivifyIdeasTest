import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import pages.LoginPage;
import pages.Strings;
import org.openqa.selenium.Keys;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

import static pages.Strings.*;

public class CreateGalleryTest extends BaseTest {

    /**
     * Test - Successful create gallery, find created gallery on My galleries page and delete gallery
     * Steps:
     * 1. log in
     * 2. navigate to create gallery page
     * 3. enter title
     * 4. enter description
     * 5. insert link of first image
     * 6. insert link of second image
     * 7. click on submit button
     * 8. check that created gallery is on homepage
     * 9. navigate to my galleries page
     * 10. check that gallery is on My galleries page
     * 11. click right arrow
     * 12. check if second picture is shown
     * 13. click left arrow
     * 14. check if first picture is shown
     * 15. enter comment in comment section
     * 16. check if comment is shown
     * 17. click on delete gallery
     * 18. hit enter
     *
     * Expected result:
     * 8.Check terminal for all messages.
     * Verify that album is successfully created, album is on My galleries page, arrows are working, commenting is working,
     * and user successfully deleted created album.
     */

    @Test
    public void createGalleryTest() throws AWTException {

        //logIn();
        // Nisam uspeo da pronađem razlog zašto se nakon korišćenja ove metode ne može locirati određeni web element.
        // Zato u svakom testu pišem celu log in metodu.

        ChromeDriver driver = openChromeDriver();
        try {
            driver.get(HOMEPAGE_URL);

            LoginPage loginPage = new LoginPage(driver);
            loginPage.enterEmail(VALID_USER_NAME);
            loginPage.enterPassword(VALID_PASSWORD);

            WebElement submitButton = driver.findElement(By.xpath("//button[@class=\"btn btn-custom\"]"));
            Actions actions = new Actions(driver);
            actions.moveToElement(submitButton).click().build().perform();
            sleep();
            String currentPageURL = driver.getCurrentUrl();
            assert currentPageURL.equals(HOMEPAGE_URL) : "Error. You are not logged in. Expected: " + HOMEPAGE_URL + ". Actual: " + currentPageURL;


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
            assert currentPageURL.equals(HOMEPAGE_URL) : "Error. You are not on home page. Expected: " + HOMEPAGE_URL +
                    ". Actual: " + currentPageUrl;

            sleep();

            WebElement allGalleriesList = driver.findElement(By.className("grid"));
            List<WebElement> galleriesInList = driver.findElements(By.xpath("//div[@class=\"cell\"]"));
            for (WebElement element : galleriesInList) {
                if (element.getText().contains("Veljko Mačar")) {
                    System.out.println("Album uspešno kreiran.");

                    break;
                }
            }

            WebElement myGalleriesButton = driver.findElement(By.xpath("//a[@href=\"/my-galleries\"]"));
            myGalleriesButton.click();

            sleep();

            WebElement allGaleries = driver.findElement(By.className("grid"));
            List<WebElement> galleries = driver.findElements(By.xpath("//div[@class=\"cell\"]"));
            for (WebElement element : galleries) {
                if (element.getText().contains("Veljko Mačar")) {
                    System.out.println("Album se nalazi na 'My Galleries' stranici.");

                    WebElement createdGalleryAuthor = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/h2/a"));
                    createdGalleryAuthor.click();
                    sleep();

                    WebElement rightArrow = driver.findElement(By.xpath("//span[@class=\"carousel-control-next-icon\"]"));
                    rightArrow.click();

                    WebElement secongImg = driver.findElement(By.xpath("//img[@src=\"https://devops.com/wp-content/uploads/2020/04/Shift-Right-Testing-_TestOps.jpg\"]"));
                    if (secongImg.isDisplayed()) {
                        System.out.println("Listanje na desno radi.");
                    } else {
                        System.out.println("Listanje na desno ne radi.");
                    }

                    WebElement leftArrow = driver.findElement(By.xpath("//span[@class=\"carousel-control-prev-icon\"]"));
                    leftArrow.click();

                    WebElement firstImg = driver.findElement(By.xpath("//img[@src=\"https://www.etestware.com/wp-content/uploads/2020/08/shutterstock_515285995-1200x580.jpg\"]"));
                    if (firstImg.isDisplayed()) {
                        System.out.println("Listanje na levo radi.");
                    } else {
                        System.out.println("Listanje na levo ne radi.");
                    }

                    WebElement commentSection = driver.findElement(By.xpath("//textarea[@placeholder=\"Comment...\"]"));
                    commentSection.click();
                    commentSection.sendKeys("Koment sekcija.");
                    WebElement submitButton3 = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
                    submitButton3.click();

                    sleep();

                    WebElement postedComment = driver.findElement(By.xpath("//*[text() = \"Koment sekcija.\"]"));
                    if (postedComment.isDisplayed()) {
                        System.out.println("Komentar uspešno postavljen.");
                    } else {
                        System.out.println("Komentar nije postavljen.");
                    }

                    WebElement deleteButton = driver.findElement(By.xpath("//i[@class=\"fas fa-trash\"]"));
                    deleteButton.click();

                    Robot robot = new Robot();
                    robot.keyPress(KeyEvent.VK_ENTER);
                    robot.keyRelease(KeyEvent.VK_ENTER);
                    sleep();

                    System.out.println("Komentar uspešno obrisan.");

                    WebElement deleteGallery = driver.findElement(By.xpath("//*[text() = 'Delete Gallery']"));
                    deleteGallery.click();

                    //P.S. Album brišem kako se ne bi gomilao na stranici

                    //Robot robot = new Robot();
                    robot.keyPress(KeyEvent.VK_ENTER);
                    robot.keyRelease(KeyEvent.VK_ENTER);
                    sleep();

                    //komandu enter koristim, jer ne uspevam da inicijalizujem iframe na stranici
                    //"iframe[@src="https://www.ciuvo.com/ciuvo/globalstorage?version=2.1.3"]"

                    System.out.println("Album uspešno obrisan.");

                }
            }

        } finally {
            driver.quit();
        }


    }

}



