package com.globalsqa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransactionsPage {
    public WebDriver driver;

    public TransactionsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy (xpath = "//tr[@id='anchor0']//td[1]")
    public static WebElement creditDate;

    @FindBy (xpath = "//tr[@id='anchor0']//td[2]")
    public static WebElement creditAmount;

    @FindBy (xpath = "//tr[@id='anchor0']//td[3]")
    public static WebElement creditType;

    @FindBy(xpath = "//tr[@id='anchor1']//td[1]")
    public static WebElement debitDate;

    @FindBy (xpath = "//tr[@id='anchor1']//td[2]")
    public static WebElement debitAmount;

    @FindBy (xpath = "//tr[@id='anchor1']//td[3]")
    public static WebElement debitType;

    @FindBy (xpath = "//button[contains(text(),'Back')]")
    public static WebElement backButton;

}
