Feature: Logout
  Scenario: Logout from saucedemo website
    Given User logged in
    And   User navigate to left sidebar
    When  User click logout button
    Then  User back to saucedemo website login page