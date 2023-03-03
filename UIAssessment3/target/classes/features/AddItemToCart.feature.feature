Feature: test the inventory page
  Scenario:adds n number of items to the cart and verifies that all n items are in the cart
    Given user is on the inventory page
    When user clicks on add to cart multiple times to add multiple items
    Then the item should be added to the cart
    When user clicks on the cart
    Then user should be taken to the cart page



  Scenario:adds 3 number of items(a bike bight being the third item) to the cart and verifies that all n items are in the cart
    Given user is on the inventory page
    When user clicks on add to cart to three items
    Then all three items item should be added to the cart
    When user clicks on the cart
    Then user should be taken to the cart page
    When user clicks on the manu bar
    Then the menu to navigate to the other pages should be displayed
    When user clicks on all items link
    Then user should be back on the inventory page
    When user clicks on the remove button
    Then item should be removed from the cart.


  Scenario:adds n number of items to the cart and verifies that all n items are in the cart
    Given user is on the inventory page
    When user clicks on add to cart multiple times to add multiple items
    Then the item should be added to the cart
    When user clicks on the cart
    Then user should be taken to the cart page
    When user clicks on the menu bar
    And clicks on the logout button
    Then user should be logged out
    And user should be on the login page
    When user enters correct username and correct password
    And clicks on the login button
    Then user should be navigated to the inventory page
    When user clicks on the cart
    Then user should be navigated to the cart page



