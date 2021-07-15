Feature: Account page feature

Background:
Given user has already logged in to the application
|username|password|
|rajesh.yemul@gmail.com|Test@1234|

Scenario: Verify Account page title
Given user is on Accounts page
When user reads the title of the page
Then page title should be "My account - My Store"


Scenario: Verify Accounts section count
Given user is on Accounts page
Then user reads Accounts section
|ORDER HISTORY AND DETAILS|
|MY CREDIT SLIPS|
|MY ADDRESSES|
|MY PERSONAL INFORMATION|
|MY WISHLISTS|
|Home|
And Accounts sections count should be 6
