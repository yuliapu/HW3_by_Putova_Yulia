package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Auto {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;


  @Before
  public void setUp() throws Exception {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
  }

  @Test
  public void testAuto() throws Exception {
    driver.get(baseUrl);
    driver.findElement(By.id("lst-ib")).sendKeys("selenium webdriver");
    driver.findElement(By.id("lst-ib")).sendKeys(Keys.ENTER);
  }

  @After
  public void tearDown() throws Exception {
    //driver.quit();

  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
