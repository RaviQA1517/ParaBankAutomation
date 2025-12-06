package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitHelper;

public class AccountOverviewPage {

    private WebDriver driver;
    private WaitHelper wait;

    @FindBy(linkText = "Accounts Overview")
    private WebElement accountsOverviewLink;

    @FindBy(id = "accountTable")
    private WebElement accountTable;

    public AccountOverviewPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WaitHelper(driver);
    }

    public boolean navigateToAccountsOverview() {

        wait.waitForElementToBeClickable(By.linkText("Accounts Overview"));
        accountsOverviewLink.click();

        wait.waitForElementToBeVisible(By.id("accountTable"));
        return accountTable.isDisplayed();
    }


}

