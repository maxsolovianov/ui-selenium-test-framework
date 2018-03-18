package tests;

import org.junit.experimental.categories.Category;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import testOrganization.HappyPath;

public class LoginTest extends BaseTest {

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

    }
}
