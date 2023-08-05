@Gramedia
Feature: Transaction Flow

  Background: Login with Email
    Given user login to Gramedia
    And user wait 5 seconds

  @GRA-001
  Scenario: As a user, I want to add the product to the cart
    When user search book
    And user wait 15 seconds
    And user click book
    And user wait 15 seconds
    And user click format
    And user wait 15 seconds
    And user choose format
    And user wait 15 seconds
    And user click cart
    And user wait 15 seconds
    Then user will find success text