package Pages;

import Utilities.BrowserDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PersonalDetailsPage2 extends BrowserDriver {
    private static final By Gender_TxtBx_XPATH = By.xpath("//div[@id='gender']");
    private static final By Female_XPATH = By.xpath("//li[@data-value='F']");
    private static final By DateOfBirth_TxtBx_XPATH = By.xpath("//input[@id='input_birth_date']");
    private static final By TC_CheckBx_XPATH = By.xpath("//input[@id='acceptTC']");

    private static final By Continue_Btn_XPATH = By.xpath("//button[@id='confirmBtn']");
    public static void InputPersonalData(String Date ) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement GenderDDLElement = wait.until(ExpectedConditions.elementToBeClickable(Gender_TxtBx_XPATH));
        GenderDDLElement.click();
        WebElement Gender = wait.until(ExpectedConditions.elementToBeClickable(Female_XPATH));
        Gender.click();
        WebElement CalenderElement = wait.until(ExpectedConditions.elementToBeClickable(DateOfBirth_TxtBx_XPATH));
        CalenderElement.sendKeys(Date);
        WebElement TCElement = wait.until(ExpectedConditions.elementToBeClickable(TC_CheckBx_XPATH));
        TCElement.click();
        Thread.sleep(2000);
    }

    public static void ClickContinue() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement ClickContinue = wait.until(ExpectedConditions.elementToBeClickable(Continue_Btn_XPATH));
        ClickContinue.click();
    }
}
