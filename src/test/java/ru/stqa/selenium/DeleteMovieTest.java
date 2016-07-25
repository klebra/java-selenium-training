package ru.stqa.selenium;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import static org.testng.Assert.assertTrue;

public class DeleteMovieTest extends TestNgTestBase {

    @Test
    public void deleteMovie() {
        login();
        driver.get(baseUrl + "/php4dvd/#!/sort/name%20asc/");
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("results")));
        Integer resultsCounter = driver.findElement(By.id("results")).findElements(By.tagName("a")).size();
        if (resultsCounter > 0){
            driver.findElements(By.className("title")).get(0).click();
        } else {
            Assert.fail("No movies to delete");
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[alt=\"Remove\"]")));
        driver.findElement(By.cssSelector("img[alt=\"Remove\"]")).click();
        Alert deleteConfirmation = driver.switchTo().alert();
        deleteConfirmation.accept();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("results")));
        Integer resultsCounterAfter = driver.findElement(By.id("results")).findElements(By.tagName("a")).size();
        assertTrue(resultsCounterAfter.equals(resultsCounter - 1));
        logout();
    }
}
