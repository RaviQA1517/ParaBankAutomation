package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitHelper;
import org.openqa.selenium.By;


public class OpenNewAccountPage {

    WebDriver driver;
    WaitHelper waitHelper;

    // --- LOCATORS (By) ---
    By accountTypeDropdownBy = By.id("type");
    By fromAccountDropdownBy = By.id("fromAccountId");
    By openAccountButtonBy = By.cssSelector("input.button");
    By newAccountIdBy = By.id("newAccountId");

    // --- WEBELEMENTS (PageFactory) ---
    @FindBy(id = "type")
    WebElement accountTypeDropdown;

    @FindBy(id = "fromAccountId")
    WebElement fromAccountDropdown;

    @FindBy(css = "input.button")
    WebElement openAccountButton;

    @FindBy(id = "newAccountId")
    WebElement newAccountId;


    // Constructor
    public OpenNewAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
    }

    // --- ACTION ---
    public void openNewAccount(String accountType, String fromAccount) {

        // Wait using By locators
        waitHelper.waitForElement(accountTypeDropdownBy);
        accountTypeDropdown.sendKeys(accountType);

        waitHelper.waitForElement(fromAccountDropdownBy);
        fromAccountDropdown.sendKeys(fromAccount);

        waitHelper.waitForElement(openAccountButtonBy);
        openAccountButton.click();
    }

    public String openNewSavingsAccount(String accountType, String fromAccount) {

        waitHelper.waitForElement(accountTypeDropdownBy);
        accountTypeDropdown.sendKeys(accountType);

        waitHelper.waitForElement(fromAccountDropdownBy);
        fromAccountDropdown.sendKeys(fromAccount);

        waitHelper.waitForElement(openAccountButtonBy);
        openAccountButton.click();

        waitHelper.waitForElement(newAccountIdBy);
        return newAccountId.getText();
    }


}



