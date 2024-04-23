package com.globalsqa;

import io.qameta.allure.Step;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Setups {
    public static WebDriver driver;

    public static LoginPage loginPage;

    public static MainPage mainPage;

    public static UserPage userPage;

    public static TransactionsPage transactionsPage;

    @BeforeClass
    @Step ("Подключение к hub")
    public static void settings() throws MalformedURLException {

        /*DesiredCapabilities desiredCapabilities = new DesiredCapabilities(); //Не standalone потребуется прописывание роли. Если понадобится конкретный браузер и система
        desiredCapabilities.setBrowserName("crome");
        desiredCapabilities.setPlatform(Platform.WIN10);*/

        ChromeOptions options = new ChromeOptions();//более изящное решение через standalone

        driver = new RemoteWebDriver(new URL("http://localhost:4444"), options);

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

        loginPage = new LoginPage(driver);

        mainPage = new MainPage(driver);

        userPage =new UserPage(driver);

        transactionsPage = new TransactionsPage(driver);


    }

    @AfterClass
    @Step ("Выключение")
    public static void turnOff() {

        driver.quit();

    }
}
