package com.petstore.utils;

import com.petstore.config.TestConfig;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

/**
 * API Client utility class for making HTTP requests to Petstore API
 */
public class ApiClient {
    private static ApiClient instance;
    private final TestConfig config;
    
    private ApiClient() {
        this.config = TestConfig.getInstance();
        setupRestAssured();
    }
    
    public static ApiClient getInstance() {
        if (instance == null) {
            instance = new ApiClient();
        }
        return instance;
    }
    
    private void setupRestAssured() {
        RestAssured.baseURI = config.getBaseUrl();
        RestAssured.basePath = "/" + config.getApiVersion();
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
    
    /**
     * Create a base request specification with common settings
     */
    private RequestSpecification getBaseRequest() {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON);
    }
    
    /**
     * Perform GET request
     */
    public Response get(String endpoint) {
        return getBaseRequest()
                .when()
                .get(endpoint)
                .then()
                .extract()
                .response();
    }
    
    /**
     * Perform GET request with path parameters
     */
    public Response get(String endpoint, Map<String, Object> pathParams) {
        return getBaseRequest()
                .pathParams(pathParams)
                .when()
                .get(endpoint)
                .then()
                .extract()
                .response();
    }
    
    /**
     * Perform POST request with body
     */
    public Response post(String endpoint, Object body) {
        return getBaseRequest()
                .body(body)
                .when()
                .post(endpoint)
                .then()
                .extract()
                .response();
    }
    
    /**
     * Perform PUT request with body
     */
    public Response put(String endpoint, Object body) {
        return getBaseRequest()
                .body(body)
                .when()
                .put(endpoint)
                .then()
                .extract()
                .response();
    }
    
    /**
     * Perform DELETE request
     */
    public Response delete(String endpoint) {
        return getBaseRequest()
                .when()
                .delete(endpoint)
                .then()
                .extract()
                .response();
    }
    
    /**
     * Perform DELETE request with path parameters
     */
    public Response delete(String endpoint, Map<String, Object> pathParams) {
        return getBaseRequest()
                .pathParams(pathParams)
                .when()
                .delete(endpoint)
                .then()
                .extract()
                .response();
    }
    
    /**
     * Perform POST request with form data (for file uploads)
     */
    public Response postWithFormData(String endpoint, Map<String, Object> formParams) {
        RequestSpecification request = RestAssured.given()
                .accept(ContentType.JSON);
        
        for (Map.Entry<String, Object> entry : formParams.entrySet()) {
            request.multiPart(entry.getKey(), entry.getValue());
        }
        
        return request
                .when()
                .post(endpoint)
                .then()
                .extract()
                .response();
    }
}
