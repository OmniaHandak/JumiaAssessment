package Pages;

import Utilities.BrowserDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BrowserDriver {

    private static final By ACCOUNT_XPATH = By.xpath("//label[@for='dpdw-login']");
    private static final By MY_ACCOUNT_XPATH = By.xpath("//a[.='Sign In']");

    private static final By CLOSE_POPUP = By.xpath("//button[@aria-label='newsletter_popup_close-cta']");

    public static void navigateToJumia() {
        driver.manage().window().maximize();
        driver.get("https://www.jumia.com.eg/en/");
        closePopup();
    }

    private static void closePopup() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(CLOSE_POPUP));
            element.click();
        } catch (Exception e) {
            System.out.println("Popup close button not found or clickable");
        }
    }

    public static void clickLoginButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement accountElement = wait.until(ExpectedConditions.elementToBeClickable(ACCOUNT_XPATH));
        accountElement.click();
    }

    public static void clickMyAccount() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement myAccountElement = wait.until(ExpectedConditions.elementToBeClickable(MY_ACCOUNT_XPATH));
        myAccountElement.click();
    }


}
