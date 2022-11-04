package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.ElementHelper;

import java.util.Random;

public class BuyProduct {
    WebDriver driver;
    WebDriverWait wait;
    ElementHelper helper;
    public BuyProduct(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 8);
        this.helper = new ElementHelper(driver);
    }
    By homeHeader=By.cssSelector("a[class='sf-OldHeader-exrQSXymhibjbWbIEpvR']");
    By searchPlaceholder=By.cssSelector(".desktopOldAutosuggestTheme-UyU36RyhCTcuRs_sXL9b");
    By searchBtn=By.cssSelector(".SearchBoxOld-cHxjyU99nxdIaAbGyX7F");
    By cartBtn=By.cssSelector("#shoppingCart");
    By firstProductText=By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/section[1]/section[1]/div[3]/div[1]/ul[1]/li[1]/div[1]/div[1]/div[1]/div[2]/div[2]/a[1]");
    By secondProductText=By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/section[1]/section[1]/div[3]/div[1]/ul[1]/li[2]/div[1]/div[1]/div[1]/div[2]/div[2]/a[1]");

    By emailPlaceholder=By.cssSelector("#txtUserName");
    By passwordPlaceholder=By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > form:nth-child(6) > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)");
    By loginBtn=By.cssSelector("#btnLogin");

    By tamamlaBtn=By.cssSelector("#continue_step_btn");
    public void checkHomePage() {
        helper.checkElementVisible(homeHeader);
    }

    public void typeSearchBookName(String kitap) {
        helper.sendKey(searchPlaceholder,kitap);
        helper.click(searchBtn);

    }

    public void addCartFirstProduct() throws InterruptedException {
        Thread.sleep(2000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0 , 500);");
        Actions builder = new Actions(driver);
        WebElement hoverElement=driver.findElement(By.xpath("/html[1]/body[1]/div[3]/main[1]/div[2]/div[1]/div[6]/div[2]/div[2]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/div[1]/a[1]/div[2]/h3[1]"));
        builder.moveToElement(hoverElement).perform();
        By addCart=By.xpath("/html[1]/body[1]/div[3]/main[1]/div[2]/div[1]/div[6]/div[2]/div[2]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/div[1]/a[1]/div[2]/button[1]");
        helper.click(addCart);
    }

    public void addCartSecondProduct() throws InterruptedException {
        Thread.sleep(2000);
        Actions builder = new Actions(driver);
        WebElement hoverElement=driver.findElement(By.xpath("/html[1]/body[1]/div[3]/main[1]/div[2]/div[1]/div[6]/div[2]/div[2]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/div[1]/a[1]/div[2]/h3[1]"));
        builder.moveToElement(hoverElement).perform();
        By addCart=By.xpath("/html[1]/body[1]/div[3]/main[1]/div[2]/div[1]/div[6]/div[2]/div[2]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/div[1]/a[1]/div[2]/button[1]/div[1]");
        helper.click(addCart);
        Thread.sleep(2000);

    }

    public void clickCartIcon() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(500 , 200);");
        By xIcon=By.cssSelector("svg[fill='#9B9B9B']");
        helper.click(xIcon);
        Thread.sleep(2000);
        helper.click(cartBtn);


    }

    public void checkFirstProduct(String urunbir) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0 , 300);");
        helper.checkElementText(firstProductText,urunbir);
    }

    public void checkSecondProduct(String uruniki) {
        helper.checkElementText(secondProductText,uruniki);
    }


    public void clickLoginBtn() {
        helper.click(loginBtn);
    }

    public void typeEmailClickLogin(String eposta) throws InterruptedException {
        helper.sendKey(emailPlaceholder,eposta);
        Thread.sleep(2000);
      //  clickLoginBtn();
        driver.findElement(By.cssSelector("#txtUserName")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);

    }

    public void typePasswordClickLogin(String sifre) throws InterruptedException {
        helper.sendKey(passwordPlaceholder,sifre);
        Thread.sleep(2000);
       // clickLoginBtn();
        driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > form:nth-child(6) > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
    }


    public void clickTamamlaBtn() {
        helper.click(tamamlaBtn);
    }
}
