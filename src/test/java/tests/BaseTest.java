package tests;

import helpers.DriverInit;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    public static WebDriver driver;

    @BeforeClass
    public static void BeforeAllTests() {
        driver = DriverInit.initDriver();
    }
}
