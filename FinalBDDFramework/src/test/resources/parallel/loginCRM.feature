Feature: Test login

Scenario: Verifying login functionality

Given navigate to url
And user enters data "username" in textbox "#LoginPage.user_name"
And user enters data "password" in textbox "#LoginPage.password"
Then user clicks on "#loginPage.logiin_button"