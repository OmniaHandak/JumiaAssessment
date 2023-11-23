package Pages;

import Utilities.BrowserDriver;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddItemsToCart extends BrowserDriver {
    private static final By Supermarket_Btn_XPATH = By.xpath("//span[.='Supermarket']");

    private static final By Bakery_Btn_XPATH = By.xpath("//a[.='Bakery']");

    private static final By Item_XPATH = By.xpath("(//button[@class='add btn _prim -pea _md'])[1]");

    private static final By Price_XPATH = By.xpath("(//div[@class='prc'])[1]");

    private static final By Price2_XPATH = By.xpath("(//div[@class='prc'])[2]");

    private static final By Cart_XPATH = By.xpath("//a[@class='-df -i-ctr -gy9 -hov-or5 -phs -fs16']");

    private static final By SubTotal_XPATH = By.xpath("//p[@class='-ow-a']");

    private static final By RemoveItem_Btns_XPATH = By.xpath("//button[@class='btn _def _ti -mra']");
    private static final By RemoveItem1_Btn_XPATH = By.xpath("(//button[@class='btn _def _ti -mra'])[1]");
    private static final By Remove_Btn_XPATH = By.xpath("//button[@class='btn _prim _i -fw -fh']");

    private static final By RemoveItem2_Btn_XPATH = By.xpath("(//button[@class='btn _def _ti -mra'])[2]");

    private static final By TotalPrice_XPATH = By.xpath("//p[@class='-fs20 -plm -tar']");

    public static void HoverSupermarket() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement SupermarketElement = wait.until(ExpectedConditions.elementToBeClickable(Supermarket_Btn_XPATH));
        WebElement elementToHover = driver.findElement(By.xpath("//span[.='Supermarket']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(elementToHover).perform();
        Thread.sleep(2000);
    }

    public static void ClickBakery() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement BakeryElement = wait.until(ExpectedConditions.elementToBeClickable(Bakery_Btn_XPATH));
        BakeryElement.click();
    }

    public static String AddItem() throws InterruptedException {
        WebElement elementToHover = driver.findElement(By.xpath("(//button[@class='add btn _prim -pea _md'])[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(elementToHover).perform();
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement Element = wait.until(ExpectedConditions.elementToBeClickable(Item_XPATH));
        Element.click();
        WebElement Price = wait.until(ExpectedConditions.elementToBeClickable(Price_XPATH));
        Thread.sleep(2000);
        String Price_Item = Price.getText();
        String result = removeChars(Price_Item, "EGP");
        result = removeChars(result,"\\s");
        System.out.println(result);
        return  result;
    }

    public static String AddItem2() throws InterruptedException {

        WebElement elementToHover = driver.findElement(By.xpath("(//button[@class='add btn _prim -pea _md'])[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(elementToHover).perform();
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement Element = wait.until(ExpectedConditions.elementToBeClickable(Item_XPATH));
        Element.click();
        WebElement Price = wait.until(ExpectedConditions.elementToBeClickable(Price2_XPATH));
        Thread.sleep(2000);
        String Price_Item = Price.getText();
        String result = removeChars(Price_Item, "EGP");
        result= removeChars(result,"\\s");
        System.out.println(result);
        return result;
    }

    public static void AssertThatUserIsNavigatedToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement CartElement = wait.until(ExpectedConditions.elementToBeClickable(SubTotal_XPATH));
    }

    public static void AssertThatSelectedItemsAddedToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement Element = wait.until(ExpectedConditions.elementToBeClickable(RemoveItem1_Btn_XPATH));
        WebElement Element2 = wait.until(ExpectedConditions.elementToBeClickable(RemoveItem2_Btn_XPATH));
    }


    public static void ClickCart() throws InterruptedException {
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement CartElement = wait.until(ExpectedConditions.elementToBeClickable(Cart_XPATH));
        CartElement.click();
    }

    public static void VerifySubtotal(String FirstItemPrice, String SecondItemPrice) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement TotalPrice = wait.until(ExpectedConditions.elementToBeClickable(TotalPrice_XPATH));
        Thread.sleep(2000);
        String TotalPrice_Item = TotalPrice.getText();
        String result = removeChars(TotalPrice_Item, "EGP");
        result = removeChars(result,"\\s");
        float subtotal = Float.parseFloat(result);
        float price1 = Float.parseFloat(FirstItemPrice);
        float price2 = Float.parseFloat(SecondItemPrice);
        float total = price1 + price2;
        System.out.println(total);
        if (total!=subtotal){
            throw new Exception("Test Failed! Subtotal doesn't Equal the total items' Price");
        }
    }

    public static void RemoveTestData() throws InterruptedException {
        java.util.List<WebElement> elements = driver.findElements(RemoveItem_Btns_XPATH);
        int i = elements.size();
        for (int x=0; x<i; x++) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement Element = wait.until(ExpectedConditions.elementToBeClickable(RemoveItem1_Btn_XPATH));
            Element.click();
            WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement Element2 = wait2.until(ExpectedConditions.elementToBeClickable(Remove_Btn_XPATH));
            Element2.click();
            Thread.sleep(2000);
        }
    }

    private static String removeChars(String originalString, String charsToRemove) {
        return originalString.replaceAll("[" + charsToRemove + "]", "");
    }

}
