package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public static String PAGE_URL;

    public void openPage() {
        driver.get(PAGE_URL);
    }

    public void closePage() {
        driver.close();
    }

    public void quitBrowser() {
        driver.quit();
    }

    public void openLink(String url) {
        driver.get(url);
    }

    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public String getCurrentTitle() {
        return driver.getTitle();
    }

    public String getPageSource() {
        return driver.getPageSource();
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

    public void waitUntilElementGetsInvisible(WebElement elementTobeInvisible) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.invisibilityOf(elementTobeInvisible));
    }

    public void waitForDocumentReadyState() {
        new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }

    public WebElement findWebElement(By by) {

        WebElement webElement = null;

        try {
            webElement = new WebDriverWait(driver, 10, 500).
                    until(ExpectedConditions.visibilityOf(driver.findElement(by)));

        } catch (org.openqa.selenium.NoSuchElementException exception) {

            System.out.println("ERROR: The element " + by.toString() + " was not found!");
            return null;

        }
        return webElement;
    }
}
