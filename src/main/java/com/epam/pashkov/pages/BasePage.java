package com.epam.pashkov.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * User: Yaroslav_Pashkov
 * Date: 27.10.2015
 * Time: 16:43
 */
public class BasePage {
    public static final String SEARCH_FIELD_XPATH = "//input[@id='edit-name-1']";

    @FindBy(xpath = SEARCH_FIELD_XPATH)
    protected WebElement searchField;

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
