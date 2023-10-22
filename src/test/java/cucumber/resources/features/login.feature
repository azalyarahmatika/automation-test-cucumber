Feature: Login to Saucedemo
  Scenario: Success login
    Given Login page
    When Input standard_username
    And Input password
    And Click login button
    Then Directed to homepage

  Scenario: Failed login
    Given Login page
    When Input locked_out_user
    And Input password
    And Click login button
    Then Get error message