package com.epam.pashkov.pages;

import com.epam.pashkov.entities.Manufacture;
import com.epam.pashkov.helpers.StringUtils;
import com.epam.pashkov.helpers.WaitingUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * User: Yaroslav_Pashkov
 * Date: 27.10.2015
 * Time: 16:59
 */
public class PricePage extends BasePage {
    public static final String MIN_PRICE_XPATH = "(//div[@class='group'])[1]//a";
    public static final String MAX_PRICE_XPATH = "(//div[@class='group'])[2]//a";
    public static final String PRODUCTS_XPATH = "//div[@class='item']";
    public static final String PRICES_XPATH = "//div[@class='price']/strong";
    public static final String MANUFACTURE_XPATH = "//div[text()='Производитель:']/following-sibling::div//a";
    public static final String COUNT_OF_PRODUCT_XPATH_X = MANUFACTURE_XPATH + "[text()='%s']" + "/following-sibling::i[1]";
    public static final String SORT_BY_PRICE_XPATH = "//div[@class='order']/a[text()='цена']";
    public static final String TOTAL_PRODUCT_COUNT_XPATH = "//div[@class='total']/b";
    public static final String SHOW_ALL_BUTTON = "//a[contains(@class,'show_common_producer')]";
    public static final String FIRST_PRODUCT_NAME_XPATH = "(//div[@class='item'])[1]/div[@class='name']/a";

    public static final String HIDE_OTHER_TEXT = "скрыть остальные";

    @FindBy(xpath = PRODUCTS_XPATH)
    private List<WebElement> productsList;

    @FindBy(xpath = PRICES_XPATH)
    private List<WebElement> pricesList;

    @FindBy(xpath = SORT_BY_PRICE_XPATH)
    private WebElement sortByPrice;

    @FindBy(xpath = MANUFACTURE_XPATH)
    private List<WebElement> manufactures;

    @FindBy(xpath = MIN_PRICE_XPATH)
    private List<WebElement> minPrices;

    @FindBy(xpath = MAX_PRICE_XPATH)
    private List<WebElement> maxPrices;

    @FindBy(xpath = TOTAL_PRODUCT_COUNT_XPATH)
    private WebElement totalProductCount;

    @FindBy(xpath = SHOW_ALL_BUTTON)
    private WebElement showAllButton;

    @FindBy(xpath = FIRST_PRODUCT_NAME_XPATH)
    private WebElement firstProductName;

    public PricePage(WebDriver driver) {
        super(driver);
    }

    public String selectMinPrice() {
        Random random = new Random();
        random.nextInt();
        WebElement minPrice = minPrices.get(random.nextInt(minPrices.size() - 1));
        String text = minPrice.getText();
        minPrice.click();
        return text;
    }

    public String selectMaxPrice() {
        Random random = new Random();
        random.nextInt();
        WebElement maxPrice = maxPrices.get(random.nextInt(maxPrices.size() - 1));
        String text = maxPrice.getText();
        maxPrice.click();
        return text;
    }

    public Manufacture selectManufacturer() {
        showAllButton.click();
        WaitingUtils.waitForTextOfElement(showAllButton, HIDE_OTHER_TEXT, driver);
        Random random = new Random();
        WebElement manuf = manufactures.get(random.nextInt(manufactures.size() - 1));
        String text = manuf.getText();
        Manufacture manufacture = new Manufacture(text, getProductsCount(text));
        manuf.click();
        return manufacture;
    }

    public int getProductsCount(String manufacture) {
        return StringUtils.getCount(driver.findElement(By.xpath(String.format(COUNT_OF_PRODUCT_XPATH_X, manufacture))).getText());
    }

    public PricePage searchFor(String value) {
        searchField.sendKeys(value);
        searchField.submit();
        return this;
    }

    public void selectSortByPrice() {
        sortByPrice.click();
    }

    public String getFirstProductName() {
        return firstProductName.getText();
    }

    public void verifyProductPrices(double min, double max) {
        List<Double> prices = new ArrayList<Double>();
        for (WebElement price : pricesList) {
            Assert.assertTrue("Filter by price doesn't work",
                    StringUtils.getPrice(price.getText()) <= max && StringUtils.getPrice(price.getText()) >= min);
        }
    }

    public void verifyProductCountByManufacture(Manufacture manufacture) {
        Assert.assertTrue("Count not corresponds", Integer.parseInt(totalProductCount.getText()) == manufacture.getProductCount());
    }

    public void verifyThatProductNameStartsWithManufacture(Manufacture manufacture) {
        for (WebElement product : productsList) {
            Assert.assertTrue("Product name doesn't start with manufacture name", product.getText()
                    .startsWith(manufacture.getName()));
        }
    }

    public void verifyProductsCount(int count) {
        Assert.assertTrue("Count is not correct", productsList.size() == count);
    }

    public void verifyFirstProductName(String name) {
        Assert.assertEquals("Product name incorrect", getFirstProductName(), name);
    }
}
