
Feature: Login Page feature

  Scenario: Login Page title validation
    Given user is on login page
    When user reads the title of the page
    Then page title should be "Login - My Store"
   
  Scenario: Validate Forgot password link is displayed
    Given user is on login page
    Then forgot password link should be displayed

	Scenario: Validate with correct credentials user can login to the application
	Given user is on login page
	When user enters username "rajesh.yemul@gmail.com"
	And user enters password "Test@1234"
	And user clicks on login button
	Then user reads the title of the page
	And page title should be "My account - My Store"