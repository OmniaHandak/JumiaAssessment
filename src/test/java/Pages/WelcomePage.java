package Pages;

import Utilities.BrowserDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WelcomePage extends BrowserDriver {
    private static final By Email_TxtBx_XPATH = By.xpath("//input[@id='input_identifierValue']");
    private static final By Continue_Btn_XPATH = By.xpath("//button[@type='submit']");
    public static void InputEmail(String email) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement EmailElement = wait.until(ExpectedConditions.elementToBeClickable(Email_TxtBx_XPATH));
        EmailElement.sendKeys(email);
        Thread.sleep(2000);
    }

    public static void ClickContinue() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement myAccountElement = wait.until(ExpectedConditions.elementToBeClickable(Continue_Btn_XPATH));
        myAccountElement.click();
    }
}
