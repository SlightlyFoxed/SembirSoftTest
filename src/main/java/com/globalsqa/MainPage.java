package com.globalsqa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    public WebDriver driver;

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    @FindBy(xpath = "//button[text()='Customer Login']") //body > div > div > div.ng-scope > div > div.borderM.box.padT20 > div:nth-child(1) > button"//button[text()='Customer Login']"
    public static WebElement customerLogButton;
}
