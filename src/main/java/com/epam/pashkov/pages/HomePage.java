package com.epam.pashkov.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

/**
 * User: Yaroslav_Pashkov
 * Date: 27.10.2015
 * Time: 16:49
 */
public class HomePage extends BasePage {

    public static final String CATEGORIES_XPATH = "//a[@class='main_page_link_catalog']";
    public static final String CATEGORY_XPATH_X = "//a[@class='main_page_link_catalog' and text()='%s']";

    @FindBy(xpath = SEARCH_FIELD_XPATH)
    protected WebElement searchField;

    @FindBy(xpath = CATEGORIES_XPATH)
    private List<WebElement> categories;

    public HomePage(WebDriver driver, boolean currentPageIsOpen) {
        super(driver);

        if (!currentPageIsOpen) {
            driver.navigate().to("http://pn.com.ua");
        }
    }

    public CategoryPage clickOnAnyCategory() {
        Random random = new Random();
        categories.get(random.nextInt(categories.size() - 1)).click();
        return new CategoryPage(driver);
    }

    public CategoryPage clickOnCategory(String category) {
        driver.findElement(By.xpath(String.format(CATEGORY_XPATH_X, category))).click();
        return new CategoryPage(driver);
    }
}
