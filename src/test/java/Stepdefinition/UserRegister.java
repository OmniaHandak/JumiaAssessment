package Stepdefinition;


import Pages.CreateAccountPage;
import Pages.PersonalDetailsPage;
import Pages.PersonalDetailsPage2;
import Pages.WelcomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static Pages.HomePage.*;
import static Pages.UserLoggedIn.*;
import static Pages.WelcomePage.*;
import static Pages.CreateAccountPage.*;
import static Pages.PersonalDetailsPage.*;
import static Pages.PersonalDetailsPage2.*;

import java.util.Random;


public class UserRegister {

    @Given("^User Navigates to Jumia$")
    public void userNavigatesToJumia() {
        navigateToJumia();
    }

    @When("^User clicks on login button$")
    public void userClicksOnLoginButton() {
        clickLoginButton();
    }

    @When("^User clicks in My Account button$")
    public void user_clicks_in_my_account_button(){
        clickMyAccount();
    }

    @When("^User Inputs valid email$")
    public void user_inputs_valid_email() throws InterruptedException {
        Random random = new Random();
        int randomInt = random.nextInt(100000);
        String randomEmail = "user_" + randomInt + "@yopmail.com";
        InputEmail(randomEmail);
        WelcomePage.ClickContinue();
    }


    @When("^User inputs (.*) and (.*)$")
    public void input_Password_And_ConfirmPassword (String PW, String ConfirmPW) throws InterruptedException {
        InputPWs(PW);
        InputConfirmPWs( ConfirmPW);
        CreateAccountPage.ClickContinue();
    }

    @When("^User Inputs personal data (.*), (.*)and (.*)$")
    public void user_inputs_personal_data_first_name_last_name_and_phone_num(String FirstName, String LastName, String Phone) throws InterruptedException {
        Random random = new Random();
        int randomInt = random.nextInt(99999999);
        String randomPhone = Phone+ randomInt ;
        if (randomPhone.length()==11){
        InputPersonalData(FirstName, LastName, randomPhone);
        PersonalDetailsPage.ClickContinue();
        }
        else{
        String Ph = Phone+ 0 ;
        InputPersonalData(FirstName, LastName, randomPhone);
        PersonalDetailsPage.ClickContinue();
        }
    }

    @When("^User selects gender, (.*) and consents the terms & conditions$")
    public void user_selects_gender_date_of_birth_and_consents_the_terms_conditions(String dateOfBirth) throws InterruptedException {
        InputPersonalData(dateOfBirth);
        PersonalDetailsPage2.ClickContinue();
    }

    @Then("^User will be logged in with (.*) and navigated to home page$")
    public void user_will_be_logged_in_and_navigated_to_home_page(String name) {
        CheckUser(name);
    }

    @Then("^Close Browser$")
    public void close_browser() {
        close();
    }
}