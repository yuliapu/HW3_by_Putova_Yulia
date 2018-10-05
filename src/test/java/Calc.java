
package com.example.tests;
import java.io.File;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Keys;

public class Calc {

    By equal = By.name("=");
    By clean = By.name("C");
    By resultbox = By.id("resultsbox");


    private WebDriver driver;

    public Calc(WebDriver driver) {
        this.driver = driver;
    }

    public String calculate(String exp) {
        for (int i = 0; i < exp.length(); i++) {

            if (driver.findElements(By.name("" + exp.charAt(i))).size() != 0)
            {
                driver.findElement(By.name("" + exp.charAt(i))).click();
            }
         else  { driver.findElement(By.id("resultsbox")).sendKeys(exp);break;}
        }
        driver.findElement(equal).click();
        return driver.findElement(resultbox).getAttribute("value");
    }
    public String display(String exp) {
        clean();
        if (exp.length()>1) return calculate(exp);

        else if (exp.length()==0){
        driver.findElement(equal).click();
        return driver.findElement(resultbox).getAttribute("value");}

        else {
        driver.findElement(By.name(exp)).click();
        return driver.findElement(resultbox).getAttribute("value");}
    }

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("calc.html").getFile());
        driver.get("file://" + file.getAbsolutePath());
    }

    public void clean() {
       driver.findElement(clean).click();
    }
    public void quit() {
        driver.quit();
    }

}



