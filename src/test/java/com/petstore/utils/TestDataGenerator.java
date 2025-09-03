package com.petstore.utils;

import com.github.javafaker.Faker;

import java.util.Random;

/**
 * Utility class for generating test data
 */
public class TestDataGenerator {
    private static final Faker faker = new Faker();
    private static final Random random = new Random();
    
    /**
     * Generate a random pet name
     */
    public static String generatePetName() {
        return faker.animal().name();
    }
    
    /**
     * Generate a random pet ID
     */
    public static long generatePetId() {
        return faker.number().numberBetween(1000L, 999999L);
    }
    
    /**
     * Generate a random username
     */
    public static String generateUsername() {
        return faker.name().username();
    }
    
    /**
     * Generate a random email
     */
    public static String generateEmail() {
        return faker.internet().emailAddress();
    }
    
    /**
     * Generate a random password
     */
    public static String generatePassword() {
        return faker.internet().password(8, 16);
    }
    
    /**
     * Generate a random first name
     */
    public static String generateFirstName() {
        return faker.name().firstName();
    }
    
    /**
     * Generate a random last name
     */
    public static String generateLastName() {
        return faker.name().lastName();
    }
    
    /**
     * Generate a random phone number
     */
    public static String generatePhoneNumber() {
        return faker.phoneNumber().phoneNumber();
    }
    
    /**
     * Generate a random pet status
     */
    public static String generatePetStatus() {
        String[] statuses = {"available", "pending", "sold"};
        return statuses[random.nextInt(statuses.length)];
    }
    
    /**
     * Generate a random order status
     */
    public static String generateOrderStatus() {
        String[] statuses = {"placed", "approved", "delivered"};
        return statuses[random.nextInt(statuses.length)];
    }
    
    /**
     * Generate a random quantity
     */
    public static int generateQuantity() {
        return faker.number().numberBetween(1, 10);
    }
    
    /**
     * Generate a random category name
     */
    public static String generateCategoryName() {
        String[] categories = {"Dogs", "Cats", "Birds", "Fish", "Reptiles", "Small Pets"};
        return categories[random.nextInt(categories.length)];
    }
    
    /**
     * Generate a random tag name
     */
    public static String generateTagName() {
        return faker.lorem().word();
    }
}
