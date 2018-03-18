package pages;

import org.openqa.selenium.WebDriver;

public class BasePage {

    public WebDriver driver;

    public BasePage (WebDriver driver) {
        this.driver = driver;
    }

    public static String PAGE_URL;

    public void openPage() {
        driver.get(PAGE_URL);
    }

    public void closePage() {
        driver.close();
    }

    public void openLink (String url) {
        driver.get(url);
    }

    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public void getCurrentURL() {
        driver.getCurrentUrl();
    }

    public void getCurrentTitle() {
        driver.getTitle();
    }

    public void getPageSource() {
        driver.getPageSource();
    }

    public void goForward() {
        driver.navigate().forward();
    }

    public void goBack() {
        driver.navigate().back();
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }
}
