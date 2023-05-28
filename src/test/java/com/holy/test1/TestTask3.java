package com.holy.test1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.urlToBe;

public class TestTask3 {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void start() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=ru");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.of(10L, ChronoUnit.SECONDS));
    }

    @Test
    public void TestLogin_Chrome() {
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        wait.until(urlToBe("http://localhost/litecart/admin/"));
    }


    @AfterEach
    public void stop() {
        driver.quit();
        driver = null;
    }
}
