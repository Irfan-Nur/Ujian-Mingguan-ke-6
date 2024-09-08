Feature: AddProduct functionality

  Scenario: Successful login with valid credentials
    Given I am on the SauceDemo login page
    When I enter a valid username and password
    And I click the login button
    Then I should be redirected to the homepage

  Scenario: Add 2 product to chart
    Given I am on the SauceDemo home product page
    When I click 2 Product to chart
    And I click the chart button
    Then I enter a SauceDemo Chart page

  Scenario: Checkout Product
    Given I am on the SauceDemo Chart page
    When I Click Checkout button
    Then I moved to Your Information Page

  Scenario: Input Information Page
    Given I am on the Your Information Page
    When I enter a Frist Name
    And I enter a Last Name
    And I enter a Zip/Postal Code
    And I click continue button
    Then I moved to SauceDemo Overview produt Page

  Scenario: Input Information Page with empty
    Given I am on the Your Information Page
    When I enter a Frist Name blank
    And I enter a Last Name blank
    And I enter a Zip/Postal Code blank
    And I click continue button
    Then I should see an error message "Error: First Name is required"

  Scenario: Overview Page
    Given I am on the Overview Page
    When I click Finish Button
    And I move to Checkout Complete Page
    Then I should see an Successfully message "Your order has been dispatched, and will arrive just as fast as the pony can get there!"
