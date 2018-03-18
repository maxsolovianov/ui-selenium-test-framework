package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.TestData.LOGIN_URL;

public class LoginPage extends BasePage {

    public static final By LOGIN_EMAIL = By.id("login-email");
    public static final By LOGIN_PASSWORD = By.id("login-password");
    public static final By BUTTON_SUBMIT = By.xpath("/html/body/section/div/div/div/div/div/form[1]/div[5]/div/button");
    public static final String TITLE_PORTAL = "Dashboard — Merchant portal";
    public static final String URL_PORTAL = "https://my-sandbox.maxpay.com/app.php#/app/dashboard";

    public static String PAGE_URL = LOGIN_URL;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get(PAGE_URL);
        maximizeWindow();
    }
}
