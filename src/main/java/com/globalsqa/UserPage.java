package com.globalsqa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPage {

    public WebDriver driver;

    public UserPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//button[contains(text(),'Deposit')]")
    public static WebElement depositButton;

    @FindBy(xpath = "//button[contains(text(),'Withdrawl')]")
    public static WebElement withdrawlButton;

    @FindBy(xpath = "//button[contains(text(),'Transactions')]")
    public static WebElement transactionsButton;

    @FindBy(xpath = "//input[@placeholder='amount']")
    public static WebElement depositField;

    @FindBy(xpath = "//div[@class='form-group']//input")
    public static WebElement withdrawField;

    @FindBy(xpath = "//button[text()='Deposit']")
    public static WebElement confirmDepositButton;

    @FindBy(xpath = "//button[text()='Withdraw']")
    public static WebElement confirmWithdrawButton;

    @FindBy(xpath = "//div[@ng-hide='noAccount'][1]/strong[2]")
    public static WebElement balanceValue;

}
