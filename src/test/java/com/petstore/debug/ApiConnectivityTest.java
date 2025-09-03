package com.petstore.debug;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

/**
 * Simple test to debug API connectivity issues
 */
public class ApiConnectivityTest {
    
    @Test
    public void testApiConnectivity() {
        try {
            System.out.println("Testing API connectivity...");
            
            // Set up RestAssured
            RestAssured.baseURI = "https://petstore.swagger.io";
            RestAssured.basePath = "/v2";
            
            // Make a simple request
            Response response = RestAssured.given()
                    .when()
                    .get("/pet/findByStatus?status=available")
                    .then()
                    .extract()
                    .response();
            
            System.out.println("Response Status Code: " + response.getStatusCode());
            System.out.println("Response Body: " + response.getBody().asString());
            
        } catch (Exception e) {
            System.err.println("Error connecting to API: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
