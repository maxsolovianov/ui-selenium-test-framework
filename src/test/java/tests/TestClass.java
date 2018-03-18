package tests;

import helpers.DriverUtil;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;

import static tests.LoginTests.loginPage;

public class TestClass {

    public static WebDriver driver;

    @BeforeClass
    public static void toDoBeforeAllTests() {
        driver = DriverUtil.initDriver();
        loginPage = new LoginPage(driver);
    }

    @AfterClass
    public static void toDoAfterAllTests() {
        loginPage.quitBrowser();
    }

    @BeforeMethod
    public static void beforeTest() {
        loginPage.openPage();
    }

    @AfterMethod
    public static void afterTest() {
    }
}
