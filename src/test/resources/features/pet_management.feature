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
  Scenario: Retrieve an existing pet by ID
    Given I have created a pet
    When I retrieve the pet by its ID
    Then the pet details should be returned
    And the pet data should match the created pet

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
  Scenario: Verify deleted pet cannot be retrieved
    Given I have created and deleted a pet
    When I try to retrieve the deleted pet
    Then I should receive a 404 not found response

  @read @negative
  Scenario: Retrieve non-existent pet
    Given I have a non-existent pet ID
    When I try to retrieve the pet by its ID
    Then I should receive a 404 not found response

  @create @negative
  Scenario: Create pet with invalid data
    Given I have invalid pet data with missing required fields
    When I try to create a new pet
    Then I should receive a 400 bad request response

  @update @negative
  Scenario: Update non-existent pet
    Given I have a non-existent pet ID
    When I try to update the pet status
    Then I should receive a 404 not found response

  @delete @negative
  Scenario: Delete non-existent pet
    Given I have a non-existent pet ID
    When I try to delete the pet
    Then I should receive a 404 not found response
