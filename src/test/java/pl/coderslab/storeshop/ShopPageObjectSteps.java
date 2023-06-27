package pl.coderslab.storeshop;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.time.Duration;

public class ShopPageObjectSteps {
    private WebDriver driver;
    private ShopAuthPage authPage;
    private ShopMyAccountPage myAccountPage;
    private ShopShoppingPage shoppingPage;

    @Given("I am on the store authentication page")
    public void iAmOnTheStoreAuthenticationPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://prod-course.coderslab.com/index.php?controller=authentication&back=my-account");
        authPage = new ShopAuthPage(driver);
    }

    @When("I am login using {string} and {string}")
    public void iLoginUsingAnd(String login, String passwd) {
        myAccountPage = authPage.loginAs(login, passwd); }

    @Then("I go to main store page")
    public void iGoToMainStorePage() {
        shoppingPage = myAccountPage.goToShoppingPage();
    }

    @When("I choose product {string}")
    public void iChooseProduct(String item) {
        shoppingPage.ChoosingItem(item);
    }

//    @Then("I see {int} % discount")
//    public void iSeeDiscount(int discount) {
//        shoppingPage.CheckingDiscount();
//    }

    @And("I choose size {string}")
    public void iChooseSize(String size) {
        shoppingPage.ChoosingSize(size);
    }

    @And("I select {int} items")
    public void iSelectItems(int qty) {
        shoppingPage.ChoosingQuantity(qty);
    }


    @When("I add items to the cart")
    public void iAddItemsToTheCart() {
        shoppingPage.AddingToCart();
    }

    @Then("I proceed to check it out")
    public void iProceedToCheckItOut() {
        shoppingPage.CheckOut();
    }

    @And("I confirm address for delivery")
    public void iConfirmAddressForDelivery() {
        shoppingPage.ConfirmAddress();
    }

    @And("I choose method of shipping")
    public void iChooseMethodOfShipping() {
        shoppingPage.ConfirmDeliveryOption();
    }

    @And("I choose payment")
    public void iChoosePayment() {
        shoppingPage.ConfirmPaymentOption();
    }

    @When("I confirm order")
    public void iConfirmOrder() {
        shoppingPage.ConfirmOrder();
    }

    @Then("I take screenshot of the order")
    public void iTakeScreenshotOfTheOrder() throws IOException {
        shoppingPage.MakeScreenshot();
    }
}
