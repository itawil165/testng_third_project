package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CarvanaHomePage {

    public CarvanaHomePage (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div[data-qa='logo-wrapper']")
    public WebElement logo;

    @FindBy(css = "div[data-qa='navigation-wrapper']>div>a")
    public List<WebElement> navigationSections;

    @FindBy(css = "[data-cv-test='headerSignInLink']")
    public WebElement signInLink;

    @FindBy(id = "usernameField")
    public WebElement emailInputBox;

    @FindBy(id = "passwordField")
    public WebElement passwordInputBox;

    @FindBy(css = "[data-cv='sign-in-submit']")
    public WebElement signInButton;

    @FindBy(css = "[data-qa='error-message-container']")
    public WebElement errorMessage;

    @FindBy(css = "[data-cv-test='headerSearchLink']")
    public WebElement searchCarsLink;
}
