@pet @delete @demo
Feature: Pet Delete Operation Demo
  As a pet store owner
  I want to demonstrate the delete functionality
  So that I can show the API accepts delete requests

  Background:
    Given the Petstore API is available

  @delete @demo @positive
  Scenario: Demonstrate delete API call functionality
    Given I have valid pet data
    When I create a new pet
    Then the pet should be created successfully
    When I delete the pet immediately
    Then the delete request should be processed successfully

  @delete @demo @positive  
  Scenario: Delete operation returns appropriate response
    Given I have valid pet data
    When I create a new pet
    Then the pet should be created successfully
    When I delete the pet immediately
    Then the delete request should be processed successfully
    And the response should indicate the operation was handled
