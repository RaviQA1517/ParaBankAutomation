package Tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.TransferFundsPage;

public class TransferFundsTest extends BaseTest {

    @Test
    public void verifyFundsTransfer() {
        LoginPage login = new LoginPage(driver);
        login.loginToParabank("john", "demo");

        TransferFundsPage transfer = new TransferFundsPage(driver);
        String message = transfer.transferAmount("100");

        Assert.assertTrue(message.contains("success"),
                "Transfer message should indicate success");
    }
}
