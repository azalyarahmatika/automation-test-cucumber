Feature: Checkout Process
  Scenario: User goes through the checkout process successfully
    Given User is on the cart page
    When User clicks the Checkout button
    Then User is directed to a page to fill out the form
    When Input first name
    And Input last name
    And Input postal code
    And User clicks the Continue button
    Then User is directed to the product overview page
    When User clicks the Finish button
    Then User is directed to the successful checkout page