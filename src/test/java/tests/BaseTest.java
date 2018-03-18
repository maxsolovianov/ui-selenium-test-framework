package tests;

import helpers.DriverUtil;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static WebDriver driver;

    @BeforeClass
    public static void BeforeAllTests() {
        driver = DriverUtil.initDriver();
    }
}
