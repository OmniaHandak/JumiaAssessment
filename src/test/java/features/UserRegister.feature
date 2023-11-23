Feature: Test Create user functionality

  Scenario Outline: check that user can create an account
    Given User Navigates to Jumia
    When  User clicks on login button
    And   User clicks in My Account button
    And   User Inputs valid email
    And   User inputs <password> and <ConfirmPW>
    And   User Inputs personal data <first name>, <last name> and <phone num>
    And   User selects gender, <date of birth> and consents the terms & conditions
    Then  User will be logged in with <first name> and navigated to home page
    And   Close Browser

    Examples:
    |password		   	  |   ConfirmPW   |  first name	 |	last name	|    phone num		|  	date of birth	|
    |User@123             |   User@123    |    first     |	   last		|    010            |     03/10/1990    |




