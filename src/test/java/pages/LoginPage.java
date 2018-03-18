package pages;

import org.openqa.selenium.WebDriver;

import static helpers.TestData.LOGIN_URL;

public class LoginPage extends BasePage {

    public static String PAGE_URL = LOGIN_URL;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get(PAGE_URL);
        maximizeWindow();
    }
}
