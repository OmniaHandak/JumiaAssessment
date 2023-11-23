package Pages;

import Utilities.BrowserDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserLoggedIn extends BrowserDriver {
    public static void CheckUser (String name ) {
        String xpath = String.format("//label[.='Hi, %s']", name);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement UserElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }

}
