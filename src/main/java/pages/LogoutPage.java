package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitHelper;

public class LogoutPage {

    private WebDriver driver;
    private WaitHelper wait;

    @FindBy(linkText = "Log Out")
    private WebElement logoutLink;

    @FindBy(id = "loginPanel")
    private WebElement loginPanel;

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WaitHelper(driver);
    }

    public boolean logoutFromApp() {

        // Use BY locator for the wait helper
        wait.waitForElementToBeClickable(By.linkText("Log Out"));
        logoutLink.click();

        wait.waitForElementToBeVisible(By.id("loginPanel"));
        return loginPanel.isDisplayed();
    }
}

