@Test
Feature: Login
  Scenario: user login to website
    Given user navigates to the login page by opening Firefox
    When user enters correct username and password values
    Then user gets directed to homepage