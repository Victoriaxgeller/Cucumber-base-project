package pages;

import core.BrowserActions;
import io.cucumber.java.bs.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocator;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static java.lang.String.format;

public class LoginPage extends BasePage {

    private BrowserActions browserActions;

    private By emailField = new By.ByCssSelector("input[name=\"email\"]");
    private By passwordField = new By.ByCssSelector("input[name=\"password\"]");
    private By submitButton = new By.ByCssSelector("[class^='Submit_submit']");

    @FindBy(css = "input[name=\"email\"]")
    @CacheLookup
    WebElement username;

    @FindBy(css = "input[name=\"password\"]")
    @CacheLookup
    WebElement passwordWithFindBy;

    public LoginPage(BrowserActions browserActions) {
        this.browserActions = browserActions;
        PageFactory.initElements(new AjaxElementLocatorFactory(browserActions.driver(), 30), this);
    }

    public LoginPage setEmail(String email) {
        browserActions.findElement(emailField)
                .sendKeys(email);
        return this;
    }

    public LoginPage setPassword(String password) {
        browserActions.findElement(passwordField)
                .sendKeys(password);
        return this;
    }

    public LoginPage setPassword2(String password) {
        passwordWithFindBy.sendKeys(password);
        return this;
    }

    public void clickSubmitButton() {
        browserActions.findElement(submitButton).click();
    }
}
