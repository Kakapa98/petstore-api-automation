package com.petstore.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Configuration class for managing test environment settings
 */
public class TestConfig {
    private static TestConfig instance;
    private Properties properties;
    
    private TestConfig() {
        loadProperties();
    }
    
    public static TestConfig getInstance() {
        if (instance == null) {
            instance = new TestConfig();
        }
        return instance;
    }
    
    private void loadProperties() {
        properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input != null) {
                properties.load(input);
            } else {
                // Set default values if config file is not found
                setDefaultProperties();
            }
        } catch (IOException e) {
            System.err.println("Error loading configuration: " + e.getMessage());
            setDefaultProperties();
        }
    }
    
    private void setDefaultProperties() {
        properties.setProperty("base.url", "http://localhost");
        properties.setProperty("api.version", "v2");
        properties.setProperty("timeout", "30");
        properties.setProperty("retry.count", "3");
    }
    
    public String getBaseUrl() {
        return properties.getProperty("base.url", "http://localhost");
    }
    
    public String getApiVersion() {
        return properties.getProperty("api.version", "v2");
    }
    
    public String getFullApiUrl() {
        return getBaseUrl() + "/" + getApiVersion();
    }
    
    public int getTimeout() {
        return Integer.parseInt(properties.getProperty("timeout", "30"));
    }
    
    public int getRetryCount() {
        return Integer.parseInt(properties.getProperty("retry.count", "3"));
    }
    
    public String getProperty(String key) {
        return properties.getProperty(key);
    }
    
    public String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }
}
