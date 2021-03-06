package ru.stqa.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class AddMovieTest1 extends TestNgTestBase {

    @Test
    public void addMoviePositive() {
        login();
        driver.get(baseUrl + "/php4dvd/#!/sort/name%20asc/");
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("results")));
        Integer resultsCounter = driver.findElement(By.id("results")).findElements(By.tagName("a")).size();
        driver.findElement(By.cssSelector("img[alt=\"Add movie\"]")).click();
        driver.findElement(By.name("name")).clear();
        driver.findElement(By.name("name")).sendKeys("Some movie");
        driver.findElement(By.name("aka")).clear();
        driver.findElement(By.name("aka")).sendKeys("Never watch this film");
        driver.findElement(By.name("year")).clear();
        driver.findElement(By.name("year")).sendKeys("2009");
        driver.findElement(By.name("duration")).clear();
        driver.findElement(By.name("duration")).sendKeys("45");
        driver.findElement(By.name("rating")).clear();
        driver.findElement(By.name("rating")).sendKeys("0.5");
        driver.findElement(By.id("submit")).click();
        driver.findElement(By.linkText("Home")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("results")));
        Integer resultsCounterAfter = driver.findElement(By.id("results")).findElements(By.tagName("a")).size();
        assertTrue(resultsCounterAfter.equals(resultsCounter + 1));
        logout();
    }
}
