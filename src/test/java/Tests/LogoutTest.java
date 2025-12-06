package Tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.LogoutPage;

public class LogoutTest extends BaseTest {

    @Test
    public void verifyLogout() {
        LoginPage login = new LoginPage(driver);
        login.loginToParabank("john", "demo");

        LogoutPage logout = new LogoutPage(driver);
        Assert.assertTrue(logout.logoutFromApp(), "Login page should appear");
    }
}
