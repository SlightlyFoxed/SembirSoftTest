package com.globalsqa;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Date;

import static com.globalsqa.MainPage.*;
import static com.globalsqa.LoginPage.*;
import static com.globalsqa.UserPage.*;
import static com.globalsqa.TransactionsPage.*;
import static com.globalsqa.Setups.*;

public class RealisationMethods {

    public static void parsing() {

        String trCreditDate = creditDate.getText();

        String trCreditAmount = creditAmount.getText();

        String trCreditType = creditType.getText();

        String trDebitDate = debitDate.getText();

        String trDebitAmount = debitAmount.getText();

        String trDebitType = debitType.getText();

        try (PrintWriter writer = new PrintWriter("src/main/resources/transactions.csv")) {

            StringBuilder sb = new StringBuilder();

            sb.append("Дата-время Транзакции");
            sb.append(",");
            sb.append("Сумма");
            sb.append(",");
            sb.append("ТипТранзакции");
            sb.append('\n');

            sb.append(trCreditDate);
            sb.append(",");
            sb.append(trCreditAmount);
            sb.append(",");
            sb.append(trCreditType);
            sb.append('\n');

            sb.append(trDebitDate);
            sb.append(",");
            sb.append(trDebitAmount);
            sb.append(",");
            sb.append(trDebitType);
            sb.append('\n');

            writer.write(sb.toString());
            writer.close();

            System.out.println("Запись в файл успешно завершена");

            attachedFile("transactions.csv");

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    @Attachment(value = "Вложение", type = "text/css", fileExtension = ".csv")
    public static byte[] attachedFile(String resourceFileName) throws IOException {
        return Files.readAllBytes(Paths.get("src/main/resources", resourceFileName));
    }

    public static int currentDay() {

        Date currentDate = new Date();

        int currentDateDate = currentDate.getDate();

        int n = currentDateDate + 1;

        return n;
    }

    public static int fibonacci(int day) {

        if (day == 0) {
            return 0;
        } else if (day == 1) {
            return 1;
        } else {
            return fibonacci(day - 1) + fibonacci(day - 2);
        }
    }

    static Integer sum = fibonacci(currentDay());


    @Step("Вход на страницу авторизации")
    public void userSelection() {

        customerLogButton.click();

    }

    @Step("Выбор пользователя и вход в аккаунт")
    public void autorization() {

        selectUser.click();

        selectHarry.click();

        loginButton.click();

    }

    @Step("Пополнение баланса")
    public void deposit() {

        depositButton.click();

        depositField.click();

        depositField.sendKeys(sum + "");

        confirmDepositButton.click();
    }

    @Step("Списание со счета")
    public void withdrawl() {

        driver.navigate().refresh();

        withdrawlButton.click();

        withdrawField.click();

        withdrawField.clear();

        String withdraw = balanceValue.getText();

        withdrawField.sendKeys(sum + "");

        confirmWithdrawButton.click();
    }

    @Step("Проверка баланса")
    public void balanceCheck(String reqBal) {
        Assert.assertEquals(balanceValue.getText(), reqBal);

    }

    @Step("Вход на страницу транзакций")
    public void enterToTransactions() {
        //Так как присутствует проблема с пропадающим списком транзакций, было перепробовано множество вариантов решения.
        //Был прикручен функционал перезапуска теста, так как проблема является абсолютно рандомно и нет возможности спросить у разработчика

        driver.navigate().refresh();

        waitForFinallyDownload();

        transactionsButton.sendKeys(Keys.ENTER);


    }

    @Step("Ожидание окончательной загрузки страницы")
    public void waitForFinallyDownload() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }

    @Step("Проверка транзакций")
    public void transactionsCheck() {

        String credExp = "Credit";

        String debExp = "Debit";

        String cred = creditAmount.getText();

        String deb = debitAmount.getText();

        String credType = creditType.getText();

        String debType = debitType.getText();

        String amountSum = String.valueOf(sum);


        if (cred.equals(amountSum) && credType.equals(credExp)) {
            System.out.println("Сумма пополнения и тип транзакции соответствуют");
        } else {
            System.out.println("Сумма пополнения и тип транзакции не соответствуют");
        }
        if (deb.equals(amountSum) && debType.equals(debExp)) {
            System.out.println("Сумма списания и тип транзакции соответствуют");
        } else {
            System.out.println("Сумма списания и тип транзакции не соответствуют");
        }
    }

    @Step("Запись данных в csv файл")
    public void dataWriting() {

        parsing();

    }


}
