package com.petstore.utils;

import io.restassured.response.Response;
import org.testng.Assert;

/**
 * Utility class for validating API responses
 */
public class ResponseValidator {
    
    /**
     * Validate response status code
     */
    public static void validateStatusCode(Response response, int expectedStatusCode) {
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(actualStatusCode, expectedStatusCode, 
            String.format("Expected status code %d but got %d. Response: %s", 
                expectedStatusCode, actualStatusCode, response.getBody().asString()));
    }
    
    /**
     * Validate response contains specific field
     */
    public static void validateFieldExists(Response response, String fieldPath) {
        Object fieldValue = response.jsonPath().get(fieldPath);
        Assert.assertNotNull(fieldValue, 
            String.format("Field '%s' should exist in response but was null. Response: %s", 
                fieldPath, response.getBody().asString()));
    }
    
    /**
     * Validate response field value
     */
    public static void validateFieldValue(Response response, String fieldPath, Object expectedValue) {
        Object actualValue = response.jsonPath().get(fieldPath);
        Assert.assertEquals(actualValue, expectedValue, 
            String.format("Field '%s' expected to be '%s' but was '%s'. Response: %s", 
                fieldPath, expectedValue, actualValue, response.getBody().asString()));
    }
    
    /**
     * Validate response is not empty
     */
    public static void validateResponseNotEmpty(Response response) {
        String responseBody = response.getBody().asString();
        Assert.assertNotNull(responseBody, "Response body should not be null");
        Assert.assertFalse(responseBody.trim().isEmpty(), "Response body should not be empty");
    }
    
    /**
     * Validate response contains error message
     */
    public static void validateErrorMessage(Response response, String expectedMessage) {
        String actualMessage = response.jsonPath().getString("message");
        Assert.assertTrue(actualMessage.contains(expectedMessage), 
            String.format("Error message should contain '%s' but was '%s'", 
                expectedMessage, actualMessage));
    }
    
    /**
     * Validate response time is within acceptable limits
     */
    public static void validateResponseTime(Response response, long maxTimeInMs) {
        long responseTime = response.getTime();
        Assert.assertTrue(responseTime <= maxTimeInMs, 
            String.format("Response time %d ms exceeded maximum allowed time %d ms", 
                responseTime, maxTimeInMs));
    }
    
    /**
     * Validate response content type
     */
    public static void validateContentType(Response response, String expectedContentType) {
        String actualContentType = response.getContentType();
        Assert.assertTrue(actualContentType.contains(expectedContentType), 
            String.format("Expected content type to contain '%s' but was '%s'", 
                expectedContentType, actualContentType));
    }
    
    /**
     * Validate array response size
     */
    public static void validateArraySize(Response response, String arrayPath, int expectedSize) {
        int actualSize = response.jsonPath().getList(arrayPath).size();
        Assert.assertEquals(actualSize, expectedSize, 
            String.format("Array '%s' expected size %d but was %d", 
                arrayPath, expectedSize, actualSize));
    }
    
    /**
     * Validate array response is not empty
     */
    public static void validateArrayNotEmpty(Response response, String arrayPath) {
        int size = response.jsonPath().getList(arrayPath).size();
        Assert.assertTrue(size > 0, 
            String.format("Array '%s' should not be empty but had size %d", arrayPath, size));
    }
}
