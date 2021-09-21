

Feature: OpenPayd Task
@wip
Scenario: Search an item, add them into the cart and check them

Given User should be able to navigate to homepage and checks it is homepage
When User should be able to search an item through the search box
And User can add the non-discounted products into the cart
Then User checks that if there are non-discounted products in the cart or not

