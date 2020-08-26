package steps;

import core.BrowserActions;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class GoogleSearchSteps {
    BrowserActions browserActions = new BrowserActions();

    @Given("browser is open")
    public void browser_is_open() {
        browserActions.openBrowser();
    }

    @And("user is on google search page")
    public void user_is_on_google_search_page() {
        browserActions.openAbsoluteUrl("https://google.com/");
    }

    @When("user enters a text in search box")
    public void user_enters_a_text_in_search_box() {
        WebElement searchField = browserActions.driver().findElement(By.name("q"));
        searchField.clear();
        searchField.sendKeys("Step by step automation");
    }

    @And("hits enter")
    public void hits_enter() {
//        WebElement searchButton = driver.findElement(By.className("gNO89b"));
        WebElement searchField = browserActions.driver().findElement(By.name("q"));
        searchField.sendKeys(Keys.ENTER);
//        searchButton.click();
    }

    @Then("user is navigated to search results")
    public void user_is_navigated_to_search_results() throws InterruptedException {
        WebElement resultsTitle = browserActions.driver().findElement(By.cssSelector("#result-stats"));
        Assert.assertTrue(resultsTitle.isDisplayed());
    }

    @And("search results count is more then {int}")
    public void searchResultsCountIsMoreThen(int count) {
        WebElement resultsTitle = browserActions.driver().findElement(By.cssSelector("#result-stats"));
        String resultsTitleText = resultsTitle.getText();
        long resultsCount = Long.parseLong(
                resultsTitleText.split("\\(")[0]
                        .replaceAll("\\D", ""));

        Assert.assertTrue(resultsCount > count);
        browserActions.closeBrowser();
    }
}
