package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitHelper;

public class TransferFundsPage {

    private WebDriver driver;
    private WaitHelper wait;

    @FindBy(id = "amount")
    private WebElement amountField;

    @FindBy(id = "fromAccountId")
    private WebElement fromAccountDropdown;

    @FindBy(id = "toAccountId")
    private WebElement toAccountDropdown;

    @FindBy(css = "input[value='Transfer']")
    private WebElement transferButton;

    @FindBy(css = "#transferMessage")
    private WebElement transferMessage;

    public TransferFundsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WaitHelper(driver);
    }

    // ⚠️ THIS IS THE METHOD YOUR TEST IS CALLING
    public String transferAmount(String amount) {

        // Amount
        wait.waitForElementToBeVisible(By.id("amount"));
        amountField.clear();
        amountField.sendKeys(amount);

        // Select first available accounts (default behavior)
        wait.waitForElementToBeVisible(By.id("fromAccountId"));
        fromAccountDropdown.click();

        wait.waitForElementToBeVisible(By.id("toAccountId"));
        toAccountDropdown.click();

        // Transfer
        wait.waitForElementToBeClickable(By.cssSelector("input[value='Transfer']"));
        transferButton.click();

        // Confirmation message
        wait.waitForElementToBeVisible(By.cssSelector("#transferMessage"));
        return transferMessage.getText();
    }
}

