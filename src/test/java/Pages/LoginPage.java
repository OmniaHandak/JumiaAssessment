package Pages;

import Utilities.BrowserDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BrowserDriver {
    private static final By PW_TxtBx_XPATH = By.xpath("//input[@name='password']");

    private static final By Login_Btn_XPATH = By.xpath("(//span[@class='mdc-button__touch'])[1]");

    public static void InputPassword(String PW) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement PwElement = wait.until(ExpectedConditions.elementToBeClickable(PW_TxtBx_XPATH));
        PwElement.sendKeys(PW);
    }

    public static void ClickLogin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement myAccountElement = wait.until(ExpectedConditions.elementToBeClickable(Login_Btn_XPATH));
        myAccountElement.click();
    }
}
