package com.epam.pashkov.steps;

import com.epam.pashkov.entities.Manufacture;
import com.epam.pashkov.helpers.DriverFactory;
import com.epam.pashkov.pages.CategoryPage;
import com.epam.pashkov.pages.HomePage;
import com.epam.pashkov.pages.PricePage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.ResourceBundle;

/**
 * User: Yaroslav_Pashkov
 * Date: 27.10.2015
 * Time: 17:36
 */
public class PriceFilterSteps {
    private WebDriver driver;
    private HomePage homePage;
    private CategoryPage categoryPage;
    private PricePage pricePage;
    private double min, max;
    private Manufacture manufacture;
    private String cheapProduct;
    private String count;

    @Before
    public void setUp() {
        driver = DriverFactory.getDriver(ResourceBundle.getBundle("testing").getString("driver"));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("Open site pn.com.ua")
    public void openPnHomePage() {
        homePage = new HomePage(driver, false);
    }

    @When("Select category \"(.*)\"")
    public void selectAnyCategory(String category) {
        categoryPage = homePage.clickOnCategory(category);
    }

    @When("Select subcategory \"(.*)\"")
    public void selectSubcategory(String subcategory) {
        pricePage = categoryPage.selectSubcategory(subcategory);
    }

    @When("Set the minimum and maximum price")
    public void setMinMaxPrice() {
        this.min = Double.parseDouble(pricePage.selectMinPrice());
        this.max = Double.parseDouble(pricePage.selectMaxPrice());
    }

    @Then("The results satisfy the search parameters")
    public void verifyResults() {
        pricePage.verifyProductPrices(min, max);
    }

    @When("Select any manufacturer")
    public void selectManufacturer() {
        this.manufacture = pricePage.selectManufacturer();
    }

    @Then("Check that the number of goods equal to the amount specified beside the name")
    public void verifyCountOfProducts() {
        pricePage.verifyProductCountByManufacture(manufacture);
    }

    @Then("Check that names of products start with manufacturer name")
    public void verifyThatProductNameStartsWithManufacture() {
        pricePage.verifyThatProductNameStartsWithManufacture(manufacture);
    }

    @When("Sort goods by price")
    public void sortProductsByPrice() {
        pricePage.selectSortByPrice();
    }

    @When("Take the name of cheapest product")
    public void rememberCheapProductName() {
        cheapProduct = pricePage.getFirstProductName();
    }

    @When("Enter name in search field")
    public void searchProduct() {
        pricePage.searchFor(cheapProduct);
    }

    @Then("Check that result is equal \"(.*)\"")
    public void verifyCountProducts(int count) {
        pricePage.verifyProductsCount(count);
    }

    @Then("Check that the name of the product is equal to the name specified")
    public void verifyFirstProductName() {
        pricePage.verifyFirstProductName(cheapProduct);
    }
}
