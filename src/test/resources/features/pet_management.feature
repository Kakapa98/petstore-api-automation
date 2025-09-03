@pet @smoke
Feature: Pet Management
  As a pet store owner
  I want to manage pets in my store
  So that I can track inventory and sales

  Background:
    Given the Petstore API is available

  @create @positive
  Scenario: Create a new pet successfully
    Given I have valid pet data
    When I create a new pet
    Then the pet should be created successfully
    And the response should contain the pet details

  @read @positive
  Scenario: Retrieve pet immediately after creation
    Given I have valid pet data
    When I create a new pet
    Then the pet should be created successfully
    When I retrieve the pet by its ID immediately
    Then the pet details should be returned or handled appropriately

  @update @positive
  Scenario: Update pet status successfully
    Given I have created a pet with status "available"
    When I update the pet status to "sold"
    Then the pet status should be updated successfully
    And the pet status should be "sold"

  @update @positive
  Scenario: Update pet information successfully
    Given I have created a pet
    When I update the pet name to "Updated Pet Name"
    Then the pet should be updated successfully
    And the pet name should be "Updated Pet Name"

  @delete @positive
  Scenario: Delete an existing pet
    Given I have created a pet
    When I delete the pet
    Then the pet should be deleted successfully

  @delete @positive
  Scenario: Complete create-delete lifecycle demonstration
    Given I have valid pet data
    When I create a new pet
    Then the pet should be created successfully
    When I delete the pet immediately
    Then the pet should be deleted successfully

  @delete @positive
  Scenario: Verify delete operation with immediate deletion
    Given I have valid pet data
    When I create a new pet
    Then the pet should be created successfully
    When I delete the pet immediately
    Then the pet should be deleted successfully

  @read @negative
  Scenario: Retrieve non-existent pet - Demo API behavior
    Given I have a non-existent pet ID
    When I try to retrieve the pet by its ID
    Then the API should handle the request appropriately

  @create @negative
  Scenario: Create pet with minimal data - Demo API behavior
    Given I have invalid pet data with missing required fields
    When I try to create a new pet
    Then the API should accept the request and create a pet

  @update @negative
  Scenario: Update non-existent pet - Demo API behavior
    Given I have a non-existent pet ID
    When I try to update the pet status
    Then the API should handle the update request appropriately

  @delete @negative
  Scenario: Delete non-existent pet - Demo API behavior
    Given I have a non-existent pet ID
    When I try to delete the pet
    Then the API should handle the delete request appropriately
