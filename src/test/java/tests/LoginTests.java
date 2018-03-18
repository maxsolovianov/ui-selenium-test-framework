package tests;

import org.junit.Assert;
import org.junit.experimental.categories.Category;
import org.testng.annotations.*;
import pages.LoginPage;
import testOrganization.HappyPath;

import static helpers.TestData.*;
import static pages.LoginPage.*;

public class LoginTests extends TestClass {

    public static LoginPage loginPage;

    @BeforeClass
    public static void toDoBeforeAllTests() {
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

    @Category(HappyPath.class)
    @Test
    public void testLogin() {
        loginPage.waitPresenceOfElementLocated(LOGIN_EMAIL);
        loginPage.findWebElement(LOGIN_EMAIL).sendKeys(LOGIN);
        loginPage.findWebElement(LOGIN_PASSWORD).sendKeys(PASSWORD);
        loginPage.findWebElement(BUTTON_SUBMIT).click();
        loginPage.waitUntilElementGetsInvisible(loginPage.findWebElement(PAGE_LOADER));
        Assert.assertEquals(MERCHANT_PORTAL, loginPage.getCurrentTitle());
        Assert.assertEquals(URL_PORTAL, loginPage.getCurrentURL());
    }
}
