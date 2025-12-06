package Tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountOverviewPage;
import pages.LoginPage;

public class AccountOverviewTest extends BaseTest {

    @Test
    public void verifyAccountOverview() {

        LoginPage login = new LoginPage(driver);
        login.loginToParabank("john", "demo");

        AccountOverviewPage overview = new AccountOverviewPage(driver);


    }
}
