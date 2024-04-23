package com.globalsqa;

import io.qameta.allure.Flaky;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

import static com.globalsqa.Setups.*;


public class Test1 {

    RealisationMethods realisationMethods = PageFactory.initElements(driver, RealisationMethods.class);

    private static final ConfigProps confProp = ConfigProps.conf;


    @Test(suiteName = "Тестирование банковского аккаунта", testName = "Вход пользователя и изменение баланса",retryAnalyzer = Retry.class)
    @Flaky
    public void testCase1 () throws MalformedURLException {

        settings();

        realisationMethods.userSelection();

        realisationMethods.autorization();

        realisationMethods.deposit();

        realisationMethods.withdrawl();

        realisationMethods.balanceCheck(confProp.requiredBalance());

        realisationMethods.enterToTransactions();

        realisationMethods.transactionsCheck();

        realisationMethods.dataWriting();

        turnOff();
    }
}
