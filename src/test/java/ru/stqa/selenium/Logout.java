package ru.stqa.selenium;

import org.testng.annotations.*;
import org.openqa.selenium.*;

public class Logout extends TestNgTestBase{

    @Test
    public void logout() throws Exception {
        driver.findElement(By.partialLinkText("Log out")).click();
        Alert exitConfirmation = driver.switchTo().alert();
        exitConfirmation.accept();
    }

}

