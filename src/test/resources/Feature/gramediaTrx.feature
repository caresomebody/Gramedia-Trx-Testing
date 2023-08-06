@Gramedia
Feature: Transaction Flow

  Background: Login with Email
    Given user login to Gramedia
    And user wait 20 seconds

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
    Then user will find success add to cart text

  @GRA-002
  Scenario: As a user, I want to see products in my cart
    When user click cart icon
    And user wait 15 seconds
    Then user will find products in cart

  @GRA-003
  Scenario: As a user, I want to remove product from cart
    When user remove book
    And user wait 15 seconds
    Then user will find 'Tas Kamu Belanja Kamu Berdebu' text

  @GRA-004
  Scenario: As a user, I want to checkout my cart
    When user add product to cart
    And user wait 15 seconds
    And user lanjut ke pembayaran
    And user wait 15 seconds
    And user choose delivery
    And user wait 15 seconds
    Then user choose payment