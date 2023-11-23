package Pages;

import Utilities.BrowserDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PersonalDetailsPage extends BrowserDriver {
    private static final By FirstName_TxtBx_XPATH = By.xpath("//input[@id='input_first_name']");
    private static final By LastName_TxtBx_XPATH = By.xpath("//input[@id='input_last_name']");
    private static final By Phone_TxtBx_XPATH = By.xpath("//input[@name='phone[number]']");
    private static final By Continue_Btn_XPATH = By.xpath("//button[@class='mdc-button mdc-button--touch mdc-button--raised to-personal-details-part-2 mdc-ripple-upgraded']");
    public static void InputPersonalData(String FirstName, String LastName, String Phone) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement PwElement = wait.until(ExpectedConditions.elementToBeClickable(FirstName_TxtBx_XPATH));
        PwElement.sendKeys(FirstName);
        WebElement ConfirmPwElement = wait.until(ExpectedConditions.elementToBeClickable(LastName_TxtBx_XPATH));
        ConfirmPwElement.sendKeys(LastName);
        WebElement PhoneElement = wait.until(ExpectedConditions.elementToBeClickable(Phone_TxtBx_XPATH));
        PhoneElement.sendKeys(Phone);
        Thread.sleep(2000);
    }

    public static void ClickContinue() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement ClickContinue = wait.until(ExpectedConditions.elementToBeClickable(Continue_Btn_XPATH));
        ClickContinue.click();
    }
}
