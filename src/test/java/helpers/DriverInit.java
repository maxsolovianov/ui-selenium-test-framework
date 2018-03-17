package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverInit {

    public static WebDriver initDriver() {

        WebDriver driver = null;

        System.setProperty("browser", "firefox");

        String browserName = System.getProperty("browser");

        if (browserName != null) {

            if (browserName.toLowerCase().equals("chrome")) {

                System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

                driver = new ChromeDriver();
            }

            if (browserName.toLowerCase().equals("firefox")) {

                System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");

                driver = new FirefoxDriver();
            }
        }
        else {
            System.out.println("No browser was specified! Firefox will be taken by default");

            driver = new FirefoxDriver();
        }

        return driver;
    }

    public static void main (String[] args) {
        DriverInit.initDriver();
    }
}


