Feature: Test Create user functionality

  Scenario: check that user can add items to the cart
    Given User is logged in to Jumia
    When  User Hover on Supermarket then click on bakery
    And   User adds two items to cart
    Then  the item is added to the cart successfully
    And   Verify that the subtotal is calculated correctly according to the added item prices
    And   Remove test data
    And   Close Browser