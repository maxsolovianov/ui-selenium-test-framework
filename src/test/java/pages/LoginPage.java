package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.TestData.LOGIN_URL;

public class LoginPage extends BasePage {

    public static final By LOGIN_EMAIL = By.id("login-email");
    public static final By LOGIN_PASSWORD = By.id("login-password");
    public static final By BUTTON_SUBMIT = By.xpath("(//button[@type='submit'])[position()=1]");
    public static final String TITLE_PORTAL = "Dashboard — Merchant portal";
    public static final String URL_PORTAL = "https://my-sandbox.maxpay.com/app.php#/app/dashboard";
    public static final By PAGE_CONTAINER = By.xpath("//*[@id='page-container']");

    public static String PAGE_URL = LOGIN_URL;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get(PAGE_URL);
        maximizeWindow();
    }
}
