package com.epam.pashkov.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * User: Yaroslav_Pashkov
 * Date: 28.10.2015
 * Time: 12:48
 */
public class WaitingUtils {
    public static void waitForTextOfElement(final WebElement webElement, final String expectedText, WebDriver driver) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return webElement.getText().equals(expectedText);
            }
        });
    }
}
