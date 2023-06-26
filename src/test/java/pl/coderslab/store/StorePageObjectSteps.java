package pl.coderslab.store;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class StorePageObjectSteps {

    private WebDriver driver;
    private StoreAuthPage authPage;
    private StoreMyAccountPage myAccountPage;
    private StoreMyAddressesPage myAddressesPage;
    private StoreNewAddressPage newAddressPage;

    @Given("I'm on the store authentication page")
    public void iMOnTheStoreAuthenticationPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://prod-course.coderslab.com/index.php?controller=authentication&back=my-account");
        authPage = new StoreAuthPage(driver);
    }

    @When("I login using {string} and {string}")
    public void iLoginUsingAnd(String login, String passwd) {
        myAccountPage = authPage.loginAs(login, passwd);
    }

    @Then("I go to my addresses page")
    public void iGoToMyAddressesPage() {
        myAddressesPage = myAccountPage.goToMyAddressesPage();
    }

    @When("I add new address")
    public void iAddNewAddress() {
        newAddressPage = myAddressesPage.addNewAddress();
    }

    @And("I enter new address {word}, {word}, {word}, {word}, {word}")
//    @And("I enter new address {string}, {string}, {string}, {string}, {string}") // wersja bez examples
    public void iEnterNewAddress(String alias, String address, String city, String postalCode, String phoneNumber) {
        newAddressPage.enterNewAddressData(alias, address, city, postalCode, phoneNumber);
    }

    @Then("I can see new address")
    public void iCanSeeNewAddress() {
        Assertions.assertTrue(myAddressesPage.addressIsVisible(), "Created address should be visible");
    }
    @And("I verify created address {word}, {word}, {word}, {word}, {word}")
//    @And("I verify created address {string}, {string}, {string}, {string}, {string}") // wersja bez examples
    public void iVerifyCreatedAddress(String alias, String address, String city, String postalCode , String phoneNumber) {

        String user = myAccountPage.getUserName();
//        String country = newAddressPage.getCountry();
//        System.out.println(user + country);
        String addressAsText = myAddressesPage.getFirstAddressAsText();
        String expectedAddress = String.join("\n", alias, user, address, city, postalCode, "United Kingdom", phoneNumber);
        Assertions.assertEquals(expectedAddress, addressAsText);
    }

//    @And("I delete the address")
//    public void iDeleteTheAddress() {
//        myAddressesPage.removeTheAddress();
//    }

//    @And("I close the browser")
//    public void iCloseTheBrowser() {
//
//        driver.quit();
//    }
}
