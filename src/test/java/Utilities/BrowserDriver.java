package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserDriver {
    public static WebDriver driver;

    static {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/Resources/Drivers/chromedriver");

        driver = new ChromeDriver(options);
    }

    public BrowserDriver() {
        System.out.println(System.getProperty("user.dir"));
        System.out.println(driver);
        driver.get("https://www.jumia.com.eg/en/");

    }

    public static void close() {
        driver.close();
    }
}