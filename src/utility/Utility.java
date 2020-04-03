package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import java.util.Random;

public class Utility {

    public WebDriver driver;
    public static String email;
    public static String password;

    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    public void selectByVisibleText(By by, String text) {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(text);
    }

    public void selectByIndex(By by, int index) {
        Select select = new Select(driver.findElement(by));
        select.selectByIndex(index);
    }

    public void selectByValue(By by, String value) {
        Select select = new Select(driver.findElement(by));
        select.selectByValue(value);
    }

    public void mouseHoverToElement(By by) {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(by)).perform();
    }

    public void mouseHoverToElementAndClick(By by) {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(by)).click().perform();
    }

    public void randomEmailGenerator(By by) {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(10000);
        email= "Roger" + randomInt + "@gmail.com";
        driver.findElement(by).sendKeys(email);
    }

    public void randomEmailGeneratorToNextField (By by, String storeEmail){
        storeEmail = email;
        driver.findElement(by).sendKeys(storeEmail);
    }
    public void randomPasswordGenerator(By by) {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(10000);
        password = "Roger" + randomInt ;
        driver.findElement(by).sendKeys(password);
    }

    public void randomPasswordGeneratorToNextField (By by,String storePassword){
        storePassword = password;
        driver.findElement(by).sendKeys(storePassword);
    }

}
