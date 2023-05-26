package com.holy.test1;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class TestCase {

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
    public void Test_Chrome() {
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("webdriver");
        driver.findElement(By.name("btnK")).submit();
        wait.until(titleIs("webdriver - Поиск в Google"));
    }


    @AfterEach
    public void stop() {
        driver.quit();
        driver = null;
    }
}
