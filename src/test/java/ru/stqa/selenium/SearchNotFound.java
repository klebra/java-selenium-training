package ru.stqa.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchNotFound extends TestNgTestBase {

    @Test
    public void searchNotFoundTest() {
        login();
        driver.get(baseUrl + "/php4dvd/#!/sort/name%20asc/");
        driver.findElement(By.id("q")).clear();
        driver.findElement(By.id("q")).sendKeys("1234567890"); // в тесте AddMovieTest1 добавляются фильмы с названием "Some movie", так что цифры просто один из вариантов
        driver.findElement(By.id("q")).sendKeys(Keys.RETURN);
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("results")));
        Assert.assertTrue(driver.findElement(By.id("results")).findElements(By.tagName("a")).size() == 0);
        logout();
    }
}