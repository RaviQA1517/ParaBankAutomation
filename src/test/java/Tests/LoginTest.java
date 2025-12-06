package Tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {
        LoginPage login = new LoginPage(driver);
        login.loginToParabank("john", "demo");
    }
}
