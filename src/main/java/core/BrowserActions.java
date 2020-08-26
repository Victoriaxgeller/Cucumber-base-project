package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserActions extends Browser {

    /**
     * @param cssSelector
     * @return WebElement
     */
    public WebElement findElement(String cssSelector) {
        return driver.findElement(By.cssSelector(cssSelector));
    }

    public WebElement findElement(By cssSelector) {
        return driver.findElement(cssSelector);
    }

    public void openAbsoluteUrl(String url) {
        driver().navigate().to(url);
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    public WebDriverWait setWait(int milliseconds) {
        return new WebDriverWait(driver(), milliseconds);
    }
}
