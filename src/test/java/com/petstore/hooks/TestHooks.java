package com.petstore.hooks;

import com.petstore.config.TestConfig;
import com.petstore.utils.ApiClient;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

/**
 * Cucumber hooks for setup and teardown operations
 */
public class TestHooks {
    
    private TestConfig config;
    private ApiClient apiClient;
    
    @Before
    public void setUp(Scenario scenario) {
        System.out.println("Starting scenario: " + scenario.getName());
        config = TestConfig.getInstance();
        apiClient = ApiClient.getInstance();
        
        // Log test environment information
        System.out.println("Base URL: " + config.getBaseUrl());
        System.out.println("API Version: " + config.getApiVersion());
    }
    
    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println("Scenario failed: " + scenario.getName());
            // Add any cleanup logic for failed scenarios
        } else {
            System.out.println("Scenario passed: " + scenario.getName());
        }
        
        // Add any general cleanup logic here
        System.out.println("Finished scenario: " + scenario.getName());
    }
}
