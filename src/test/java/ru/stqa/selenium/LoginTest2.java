package ru.stqa.selenium;

import org.testng.annotations.Test;
import org.openqa.selenium.*;

public class LoginTest2 extends TestNgTestBase {

    @Test
    public void loginTest2() {
        driver.get(baseUrl + "/php4dvd/");
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("submit")).click();
    }
}
