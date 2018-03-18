package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.TestData.LOGIN_URL;

public class LoginPage extends BasePage {

    public static final By LOGIN_EMAIL = By.id("login-email");
    public static final By LOGIN_PASSWORD = By.id("login-password");
    public static final By BUTTON_SUBMIT = By.xpath("(//button[@type='submit'])[position()=1]");
    public static final By BUTTON_SUBMIT_IN_RUSSIAN = By.xpath("(//button[@type='submit'])[position()=2]");
    public static final By ALERT_DANGER = By.xpath("(//div[@class='alert alert-danger alert-dismissable push-15'])[position()=1]");
    public static final By VALIDATION_ON_EMPTY_EMAIL_FIELD = By.xpath("//div[@id='login-email-error']");
    public static final By VALIDATION_ON_EMPTY_PASSWORD_FIELD = By.xpath("//div[@id='login-password-error']");
    public static final By FORGOT_PASSWORD_LINK = By.xpath("//*[@ui-sref='reminder']");
    public static final By REMINDER_EMAIL_FIELD = By.xpath("//*[@id='reminder-email']");
    public static final By SUBMIT_REMINDER = By.xpath("//*[@type='submit']");
    public static final By ALERT_SUCCESS_REMINDER = By.xpath("//*[@class='alert alert-success alert-dismissable']");
    public static final By ENGLISH_ITEM = By.xpath("/html/body/div[2]/span/ul/li[1]/a");
    public static final By RUSSIAN_ITEM = By.xpath("/html/body/div[2]/span/ul/li[2]/a");
    public static final By LANGUAGE_DROPDOWN = By.xpath("//*[@class='pointer ng-scope dropdown-toggle']");
    public static final By REGISTER_LINK = By.xpath("(//*[@ui-sref='register'])");
    public static final By PAGE_LOADER = By.xpath("//*[@id='page-loader']");

    public static String PAGE_URL = LOGIN_URL;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void openPage() {
        driver.get(PAGE_URL);
        maximizeWindow();
    }
}
