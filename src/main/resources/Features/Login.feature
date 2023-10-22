Feature: User Login
  Scenario: Successful Login
    Given User is on the login page
    When User enters valid username and password
    And Clicks the login button
    Then User is logged in successfully

  Scenario: Failed Login
    Given User is on the login page
    When User enters invalid username and or password
    And Clicks the login button
    Then User receives an error message
