package com.epam.pashkov.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * User: Yaroslav_Pashkov
 * Date: 27.10.2015
 * Time: 16:36
 */
public class DriverFactory {
    public static WebDriver getDriver(String driver) {
        switch(driver) {
            case "Firefox":
                return new FirefoxDriver();
            case "Chrome":
                return new ChromeDriver();
            case "IE":
                return new InternetExplorerDriver();
        }
        return new FirefoxDriver();
    }
}
