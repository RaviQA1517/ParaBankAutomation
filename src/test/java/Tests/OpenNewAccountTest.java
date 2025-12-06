package Tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.OpenNewAccountPage;

public class OpenNewAccountTest extends BaseTest {

    @Test
    public void verifyOpenNewAccount() {
        LoginPage login = new LoginPage(driver);
        login.loginToParabank("john", "demo");

        OpenNewAccountPage acc = new OpenNewAccountPage(driver);
        String newAccId = acc.openNewSavingsAccount("SAVINGS", "12345");

        Assert.assertNotNull(newAccId);
        System.out.println("New Account Created: " + newAccId);
    }
}

