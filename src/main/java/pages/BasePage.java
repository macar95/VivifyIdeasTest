package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    ChromeDriver driver = null;

    public BasePage(ChromeDriver driver) {
        PageFactory.initElements (driver, this);
        this.driver = driver;
    }

    public BasePage() {
    }
}
