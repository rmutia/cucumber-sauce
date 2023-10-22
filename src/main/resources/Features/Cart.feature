Feature: Shopping Cart
  Scenario: Add Product to Cart
    Given User browse products
    When User adds a product to the cart
    Then Remove button displayed
    And Plus one cart item
