package tests;

import org.junit.Assert;
import org.junit.experimental.categories.Category;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import testOrganization.HappyPath;

import static helpers.TestData.*;
import static pages.LoginPage.*;

public class LoginTests extends BaseTest {

    public static LoginPage loginPage;

    @BeforeClass
    public static void toDoBeforeAllTests() {
        loginPage = new LoginPage(driver);
        loginPage.openPage();
    }

    @AfterClass
    public static void toDoAfterAllTests() {
        loginPage.closePage();
    }

    @Category(HappyPath.class)
    @Test
    public void testLogin() {
        loginPage.findWebElement(LOGIN_EMAIL).sendKeys(LOGIN);
        loginPage.findWebElement(LOGIN_PASSWORD).sendKeys(PASSWORD);
        loginPage.findWebElement(BUTTON_SUBMIT).click();
        Assert.assertEquals(URL_PORTAL, loginPage.getCurrentURL());
        Assert.assertEquals(TITLE_PORTAL, loginPage.getCurrentTitle());
    }
}
