@shopping

Feature: Shopping online

Scenario: Proceed shopping for a signed customer

Given I am on the store authentication page
When I am login using "boblop@bobo.com" and "mypass"
Then I go to main store page
When I choose product "Hummingbird Printed Sweater"
  #Then I see 20 % discount
And I choose size "M"
And I select 5 items
When I add items to the cart
Then I proceed to check it out
And I confirm address for delivery
And I choose method of shipping
And I choose payment
When I confirm order
Then I take screenshot of the order
