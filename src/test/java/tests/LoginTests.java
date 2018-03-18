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

    @Category(HappyPath.class)
    @Test
    public void loginCorrectCredentials() {
        loginPage.waitPresenceOfElementLocated(LOGIN_EMAIL);
        loginPage.findWebElement(LOGIN_EMAIL).sendKeys(LOGIN);
        loginPage.findWebElement(LOGIN_PASSWORD).sendKeys(PASSWORD);
        loginPage.findWebElement(BUTTON_SUBMIT).click();
        loginPage.waitUntilElementGetsInvisible(loginPage.findWebElement(PAGE_LOADER));
        Assert.assertEquals(MERCHANT_PORTAL, loginPage.getCurrentTitle());
        Assert.assertEquals(URL_PORTAL, loginPage.getCurrentURL());
    }

    @Test
    public void loginIncorrectCredentials() {
        loginPage.waitPresenceOfElementLocated(LOGIN_EMAIL);
        loginPage.findWebElement(LOGIN_EMAIL).sendKeys(INCORRECT_LOGIN);
        loginPage.findWebElement(LOGIN_PASSWORD).sendKeys(INCORRECT_PASSWORD);
        loginPage.findWebElement(BUTTON_SUBMIT).click();
        Assert.assertTrue(loginPage.findWebElement(ALERT_DANGER).isDisplayed());
    }

    @Test
    public void emptyFields() {
        loginPage.waitPresenceOfElementLocated(LOGIN_EMAIL);
        loginPage.findWebElement(LOGIN_EMAIL).clear();
        loginPage.findWebElement(LOGIN_PASSWORD).clear();
        loginPage.findWebElement(BUTTON_SUBMIT).click();
        Assert.assertTrue(loginPage.findWebElement(VALIDATION_ON_EMPTY_EMAIL_FIELD).isDisplayed());
        Assert.assertTrue(loginPage.findWebElement(VALIDATION_ON_EMPTY_PASSWORD_FIELD).isDisplayed());
    }

    @Test
    public void forgotPassword() {
        loginPage.waitPresenceOfElementLocated(LOGIN_EMAIL);
        loginPage.findWebElement(LOGIN_EMAIL).clear();
        loginPage.findWebElement(LOGIN_PASSWORD).clear();
        loginPage.findWebElement(BUTTON_SUBMIT).click();
        Assert.assertTrue(loginPage.findWebElement(VALIDATION_ON_EMPTY_EMAIL_FIELD).isDisplayed());
        Assert.assertTrue(loginPage.findWebElement(VALIDATION_ON_EMPTY_PASSWORD_FIELD).isDisplayed());
    }

    @Test
    public void remindPassword() {
        loginPage.waitPresenceOfElementLocated(LOGIN_EMAIL);
        loginPage.findWebElement(FORGOT_PASSWORD_LINK).click();
        loginPage.waitPresenceOfElementLocated(REMINDER_EMAIL_FIELD);
        loginPage.findWebElement(REMINDER_EMAIL_FIELD).sendKeys(LOGIN);
        loginPage.findWebElement(SUBMIT_REMINDER).click();
        Assert.assertTrue(loginPage.findWebElement(ALERT_SUCCESS_REMINDER).isDisplayed());
    }

    @Test
    public void checkRussianLanguage() {
        loginPage.waitPresenceOfElementLocated(LOGIN_EMAIL);
        loginPage.findWebElement(LANGUAGE_DROPDOWN).click();
        loginPage.findWebElement(RUSSIAN_ITEM).click();
        loginPage.waitPresenceOfElementLocated(BUTTON_SUBMIT_IN_RUSSIAN);
        Assert.assertEquals(TEXT_IN_RUSSIAN, loginPage.findWebElement(REGISTER_LINK).getText());
    }

    @Test
    public void checkEnglishLanguage() {
        loginPage.waitPresenceOfElementLocated(LOGIN_EMAIL);
        loginPage.findWebElement(LANGUAGE_DROPDOWN).click();
        loginPage.findWebElement(ENGLISH_ITEM).click();
        loginPage.waitPresenceOfElementLocated(BUTTON_SUBMIT);
        Assert.assertEquals(TEXT_IN_ENGLISH, loginPage.findWebElement(REGISTER_LINK).getText());
    }
}
