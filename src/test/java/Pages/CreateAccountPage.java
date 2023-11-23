package Pages;

import Utilities.BrowserDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreateAccountPage extends BrowserDriver {
    private static final By PW_TxtBx_XPATH = By.xpath("//input[@name='password']");
    private static final By ConfirmPW_TxtBx_XPATH = By.xpath("//input[@aria-labelledby='confirm-password']");

    private static final By Continue_Btn_XPATH = By.xpath("//button[@class='mdc-button mdc-button--touch mdc-button--raised to-personal-details mdc-ripple-upgraded']");
    public static void InputPWs(String PW) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement PwElement = wait.until(ExpectedConditions.elementToBeClickable(PW_TxtBx_XPATH));
        PwElement.sendKeys(PW);
    }
    public static void InputConfirmPWs(String ConfirmPW) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement ConfirmPwElement = wait.until(ExpectedConditions.elementToBeClickable(ConfirmPW_TxtBx_XPATH));
        ConfirmPwElement.sendKeys(ConfirmPW);
        Thread.sleep(2000);
    }
    public static void ClickContinue() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement ClickContinue = wait.until(ExpectedConditions.elementToBeClickable(Continue_Btn_XPATH));
        ClickContinue.click();
    }
}
