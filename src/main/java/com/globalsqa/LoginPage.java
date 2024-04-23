package com.globalsqa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy (xpath = "//select") //Если понадобится выбрать открыть список пользователей
    public static WebElement selectUser;

    @FindBy(xpath = "//option[text()='Harry Potter']") //Директ кнопка на Гарри
    public static WebElement selectHarry;

    @FindBy (xpath = "//button[text()='Login']")
    public static WebElement loginButton;


}
