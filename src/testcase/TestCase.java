package testcase;

import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utility.Utility;

import static org.openqa.selenium.By.xpath;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
/*
Create Java Project Name "xcart-demo-store"
baseURL: https://demostore.x-cart.com/
1.Create Two Package name "utility" and "testcase"
2.In utility package create one class name Utility and copy paste all your methods in to this utility class.
3.In testcase package create one class name TestCase.
4.In TestCase class create test methods.
    1. userShouldCreateNewAccount
    Click on "Sign in/ sign up"
    Click on "Create new account" Link
    Enter Email
    Enter password
    Enter Confirm password
    Click on create button
    Verify text "My account"
    Click on "My account" Link on right-hand side corner
    Click on "Log out" tab
    Verify "Sign in/ sign up" tab
    2. userShouldLoginSuccessfully
    Click on "Sign in/ sign up"
    Enter Email (Same email address that created in first test)
    Enter password ( Same password as created in first test)
    Click on Sign in button
    Verify text "My account"
    Click on "My account" Link on right-hand side corner
    Click on "Log out" tab
    Verify "Sign in/ sign up" tab
 */

public class TestCase extends Utility {

    @Before
    public void OpenBrowser() {
        String baseUrl = "https://demostore.x-cart.com/";
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @Test
    public void userShouldCreateNewAccount() throws InterruptedException {
        clickOnElement(xpath("//div[contains(@class,'header_bar-sign_in')]//span[contains(text(),'Sign in')]"));
        Thread.sleep(3000);
        clickOnElement(xpath("//a[contains(@class,'popup-button default-popup-button create-account-link')]"));
        Thread.sleep(3000);
        randomEmailGenerator(By.xpath("//input[@id='login']"));
        Thread.sleep(3000);
        randomPasswordGenerator(By.xpath("//input[@id='password']"));

        randomPasswordGeneratorToNextField(By.xpath("//input[@id='password-conf']"),"storePassword");
        clickOnElement(xpath("//span[contains(text(),'Create')]"));
        Thread.sleep(3000);

        String expectedText = "My account";
        String actualText = getTextFromElement(xpath("//h1[@id='page-title']"));
        Assert.assertEquals(expectedText, actualText);
        System.out.println("Expected Text : " + expectedText);
        System.out.println("Actual Text :" + actualText);

        Thread.sleep(3000);
        clickOnElement(xpath("//a[contains(text(),'My account')]"));
        clickOnElement(xpath("//ul[@class='account-links dropdown-menu']//span[contains(text(),'Log out')]"));

        String expectedTabMessage = "Sign in / sign up";
        String actualTabMessage = getTextFromElement(xpath("//div[contains(@class,'header_bar-sign_in')]//span[contains(text(),'Sign in')]"));
        Assert.assertEquals(expectedTabMessage, actualTabMessage);
        System.out.println("Expected Tab : " + expectedTabMessage);
        System.out.println("Actual Tab :" + actualTabMessage);
    }

    @Test
    public void userShouldLoginSuccessfully() throws InterruptedException {
        clickOnElement(xpath("//div[contains(@class,'header_bar-sign_in')]//span[contains(text(),'Sign in')]"));
        Thread.sleep(3000);
        clickOnElement(xpath("//input[@id='login-email']"));

        Thread.sleep(3000);
        randomEmailGeneratorToNextField(By.xpath("//input[@id='login-email']"), "storeEmail");
        randomPasswordGeneratorToNextField(By.xpath("//input[@id='login-password']"), "storePassword");
        clickOnElement(xpath("//button[contains(@class,'submit')]//span[contains(text(),'Sign in')]"));

        String expectedText = "My account";
        Thread.sleep(3000);
        String actualText = getTextFromElement(xpath("//a[contains(text(),'My account')]"));
        Assert.assertEquals(expectedText, actualText);
        System.out.println("Expected Text : " + expectedText);
        System.out.println("Actual Text :" + actualText);

        Thread.sleep(3000);
        clickOnElement(xpath("//a[contains(text(),'My account')]"));
        clickOnElement(xpath("//ul[@class='account-links dropdown-menu']//span[contains(text(),'Log out')]"));

        String expectedTabMessage = "Sign in / sign up";
        String actualTabMessage = getTextFromElement(xpath("//div[contains(@class,'header_bar-sign_in')]//span[contains(text(),'Sign in')]"));
        Assert.assertEquals(expectedTabMessage, actualTabMessage);
        System.out.println("Expected Tab : " + expectedTabMessage);
        System.out.println("Actual Tab :" + actualTabMessage);
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

}
