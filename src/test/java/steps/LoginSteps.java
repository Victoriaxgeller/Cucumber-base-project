package steps;

import core.BrowserActions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;
import pages.LoginPage;

public class LoginSteps {

    private BrowserActions browserActions = new BrowserActions();
    private LoginPage loginPage = new LoginPage(browserActions);

    @Given("user is on login page")
    public void user_is_on_login_page() {
        browserActions.openAbsoluteUrl(BasePage.BASE_URL);
    }

    @When("^user enters (.*) and (.*)$")
    public void userEntersUsernameAndPassword(String email, String password) {
        loginPage.setEmail(email).
                setPassword2(password);
    }

    @And("clicks on login button")
    public void clicks_on_login_button() {
        loginPage.clickSubmitButton();
    }

    @Then("user is navigated to the url {string}")
    public void userIsNavigatedToTheUrlMatches(String url) {
        WebDriverWait wait = browserActions.setWait(5);
        Assert.assertTrue(wait.until(ExpectedConditions.urlContains(url)));
        browserActions.closeBrowser();
    }

}
