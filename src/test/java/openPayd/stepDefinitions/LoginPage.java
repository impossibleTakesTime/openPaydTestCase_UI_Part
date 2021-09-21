package openPayd.stepDefinitions;

import io.cucumber.java.en.*;
import openPayd.pages.CartPage;
import openPayd.pages.HomePage;
import openPayd.pages.ProductionsPage;
import openPayd.utilities.ConfigurationReader;
import openPayd.utilities.Driver;

public class LoginPage {
      HomePage homePage=new HomePage();
      ProductionsPage productionsPage=new ProductionsPage();
      CartPage cartPage= new CartPage();

    @Given("User should be able to navigate to homepage and checks it is homepage")
    public void user_should_be_able_to_navigate_to_homepage_and_checks_it_is_homepage() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        homePage.checkThePage();
    }

    @When("User should be able to search an item through the search box")
    public void user_should_be_able_to_search_an_item_through_the_search_box() {
        homePage.setSearchBox("Laptop");
    }

    @When("User can add the non-discounted products into the cart")
    public void user_can_add_the_non_discounted_products_into_the_cart() {
        productionsPage.yazdir();
        CartPage cartPage=new CartPage();
        cartPage.checkCart();
    }

    @Then("User checks that if there are non-discounted products in the cart or not")
    public void user_checks_that_if_there_are_non_discounted_products_in_the_cart_or_not() {
        cartPage.checkItemsAreRight();
    }

}
