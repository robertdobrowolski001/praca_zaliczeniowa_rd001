package pl.coderslab.store;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StoreNewAddressPage {
    private final WebDriver driver;

    @FindBy(id = "field-alias")
    private WebElement aliasInput;
    @FindBy(id = "field-address1")
    private WebElement addressInput;
    @FindBy(id = "field-city")
    private WebElement cityInput;
    @FindBy(id = "field-postcode")
    private WebElement postalCodeInput;

    @FindBy(css = "#field-id_country > option:nth-child(2)")
    private WebElement countryInput;

    @FindBy(id = "field-phone")
    private WebElement phoneNumberInput;

    @FindBy(className = "form-control-submit")
    private WebElement submitBtn;

    public StoreNewAddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

//    public String getCountry(){
////        String country = countryInput.getText();
////        System.out.println(country);
//        return countryInput.getText();
//    }
    public void enterNewAddressData(String alias, String address, String city, String postalCode, String phoneNumber) {
        aliasInput.clear();
        aliasInput.sendKeys(alias);

        addressInput.clear();
        addressInput.sendKeys(address);

        cityInput.clear();
        cityInput.sendKeys(city);

        postalCodeInput.clear();
        postalCodeInput.sendKeys(postalCode);

//        String country = countryInput.getText();
//        System.out.println(country);

        phoneNumberInput.clear();
        phoneNumberInput.sendKeys(phoneNumber);

        submitBtn.click();
    }
}
