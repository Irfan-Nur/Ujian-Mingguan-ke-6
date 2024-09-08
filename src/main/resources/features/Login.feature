Feature: Login functionality

  Scenario: Successful login with valid credentials
    Given I am on the SauceDemo login page
    When I enter a valid username and password
    And I click the login button
    Then I should be redirected to the homepage

  Scenario: Login with username and without password
    Given I am on the SauceDemo login page
    When I enter an valid username and empty password
    And I click the login button
    Then I should see an error message "Epic sadface: Password is required"

  Scenario: Login with empty username
    Given I am on the SauceDemo login page
    When I leave the username field empty
    And I enter a valid password
    And I click the login button
    Then I should see an error message "Epic sadface: Username is required"

  Scenario: Login with invalid credentials
    Given I am on the SauceDemo login page
    When I enter a invalid username and password
    And I click the login button
    Then I should see an error message "Epic