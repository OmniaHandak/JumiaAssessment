package Stepdefinition;

import Pages.WelcomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static Pages.AddItemsToCart.*;
import static Pages.HomePage.*;
import static Pages.LoginPage.*;
import static Pages.UserLoggedIn.*;
import static Pages.WelcomePage.*;

public class AddToCart {
    String Price1;
    String Price2;

    @Given("^User is logged in to Jumia$")
    public void user_is_logged_in_to_jumia() throws InterruptedException {
        String UserName = "xxx@yopmail.com";
        String Password = "User@123";
        String Name = "User";
        navigateToJumia();
        clickLoginButton();
        clickMyAccount();
        InputEmail(UserName);
        WelcomePage.ClickContinue();
        InputPassword(Password);
        ClickLogin();
        CheckUser(Name);
    }

    @When("^User Hover on Supermarket then click on bakery$")
    public void user_hover_on_supermarket_then_click_on_bakery() throws InterruptedException {
        HoverSupermarket();
        ClickBakery();

    }

    @When("^User adds two items to cart$")
    public void User_adds_two_items_to_cart() throws InterruptedException {
        Price1= AddItem();
        Price2 = AddItem2();
    }

    @Then("^the item is added to the cart successfully$")
    public void the_item_is_added_to_the_cart_successfully() throws InterruptedException {
        ClickCart();
        AssertThatUserIsNavigatedToCart();
        AssertThatSelectedItemsAddedToCart();
    }

    @Then("^Verify that the subtotal is calculated correctly according to the added item prices$")
    public void verify_that_the_subtotal_is_calculated_correctly_according_to_the_added_item_prices() throws Exception {
        VerifySubtotal(Price1 ,Price2);
    }

    @Then("^Remove test data$")
    public void Remove_test_data() throws Exception {
        RemoveTestData();
    }
}
