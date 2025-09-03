package com.petstore.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * TestNG runner for Cucumber tests
 */
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.petstore.stepdefinitions", "com.petstore.hooks"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/html",
                "json:target/cucumber-reports/json/cucumber.json",
                "junit:target/cucumber-reports/xml/cucumber.xml",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber-reports/pretty"
        },
        monochrome = true,
        dryRun = false
)
public class TestRunner extends AbstractTestNGCucumberTests {
    
}
