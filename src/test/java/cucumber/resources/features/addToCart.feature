Feature: Add to Cart Functionality
  Scenario: User adds a product to the cart
    Given User is on homepage to add product
    When User clicks Add to Cart button
    Then The button changes to Remove
    And A symbol indicating the cart is not empty appears
    When User clicks on the cart
    Then User can view the corresponding product