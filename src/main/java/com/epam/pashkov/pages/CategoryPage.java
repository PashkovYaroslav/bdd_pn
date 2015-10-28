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
 * Time: 16:57
 */
public class CategoryPage extends BasePage {
    public static final String SUBCATEGORY_LINK_XPATH = "//div[contains(@class,'ct')]/a";
    public static final String SUBCATEGORY_LINK_XPATH_X = "//div[contains(@class,'ct')]/a[text()='%s']";

    @FindBy(xpath = SUBCATEGORY_LINK_XPATH)
    private List<WebElement> subcategories;

    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    public PricePage selectAnySubcategory() {
        Random random = new Random();
        subcategories.get(random.nextInt(subcategories.size() - 1)).click();
        return new PricePage(driver);
    }

    public PricePage selectSubcategory(String subcategory) {
        driver.findElement(By.xpath(String.format(SUBCATEGORY_LINK_XPATH_X, subcategory))).click();
        return new PricePage(driver);
    }
}
