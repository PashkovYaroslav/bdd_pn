package com.epam.pashkov.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.java.Before;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

/**
 * User: Yaroslav_Pashkov
 * Date: 27.10.2015
 * Time: 17:28
 */
@RunWith(Cucumber.class)
@CucumberOptions(format = { "pretty", "html:target/cucumber" },
                    glue = "com.epam.pashkov.steps",
                    features = "classpath:search_filter.feature")
public class RunFilterTest {
}
