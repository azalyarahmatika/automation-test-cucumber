Feature: Logout Functionality
  Scenario: User logs out and returns to the login page
    Given User is on homepage
    When User clicks the hamburger menu
    And User clicks Logout
    Then User is directed to login page