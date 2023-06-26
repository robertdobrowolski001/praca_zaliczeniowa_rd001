package pl.coderslab.storeshop;

import io.cucumber.java.en.And;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ShopShoppingPage {
    private final WebDriver driver;

    @FindBy(className = "ui-autocomplete-input")
    WebElement searchInput;

    @FindBy(css = "#search_widget > form > i.material-icons.search")
    WebElement searchBtn;
    @FindBy(css = "#js-product-list > div.products.row > div > article > div > div.product-description > h2 > a")
    WebElement confirmBtn;

    @FindBy(className = "bootstrap-touchspin-up")
    WebElement qtyIncrease;
    @FindBy(className = "add-to-cart")
    WebElement cartBtn;

    @FindBy(css = "#blockcart-modal > div > div > div.modal-body > div > div.col-md-7 > div > div > a")
    WebElement checkOutBtn;

    @FindBy(xpath = "//*[@id='main']/div/div[2]/div[1]/div[2]/div/a")
    WebElement checkOutBtn2;

    @FindBy(name = "confirm-addresses")
    WebElement continueBtn;

    @FindBy(css = "#js-delivery > div > div.delivery-options > div:nth-child(1) > div > span > span")
    WebElement deliveryRadioBtn;

    @FindBy(name = "confirmDeliveryOption")
    WebElement deliveryBtn;

    @FindBy(xpath = "//*[@id=\"payment-option-1\"]")
    WebElement paymentRadioBtn;

    @FindBy(xpath = "//*[@id=\"conditions_to_approve[terms-and-conditions]\"]")
    WebElement paymentConditionsBtn;

    @FindBy(css = "#payment-confirmation > div.ps-shown-by-js > button")
    WebElement paymentConfirmationBtn;


    public ShopShoppingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void ChoosingItem(String item) {
        searchInput.sendKeys(item);
        searchBtn.submit();
        confirmBtn.click();
    }

    public void CheckingDiscount() {
//        WebElement discount = driver.findElement(By.xpath("//a[text()='20%']"));
//        Assertions.assertEquals("20", discount.getText());
//                WebElement l = driver.findElement(By.xpath("//*[@id='group_1']"));
////        WebElement l = driver.findElement(By.xpath("//*[@id='main']/div[1]/div[2]/div[1]/div[2]/div/span[2]"));
//        if(l.equals(driver.switchTo().activeElement()))
//            System.out.println("Element is focused");
//        else
//            System.out.println("Element is not focused");
//        driver.close();
    }

    public void ChoosingSize(String option) {
        Select sizeDropdown = new Select(driver.findElement(By.id("group_1")));
        sizeDropdown.selectByVisibleText(option);
    }

    public void ChoosingQuantity(int qty) {
        for (int i = 1; i <= qty; i++) {
            qtyIncrease.click();
        }
    }

    public void AddingToCart() {
        cartBtn.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public void CheckOut() {
        checkOutBtn.click();
        checkOutBtn2.click();
    }

    public void ConfirmAddress() {
        continueBtn.click();
    }

    public void ConfirmDeliveryOption() {
        deliveryRadioBtn.click();
        deliveryBtn.click();
    }

    public void ConfirmPaymentOption() {
        paymentRadioBtn.click();
        paymentConditionsBtn.click();
    }

    public void ConfirmOrder() {
        paymentConfirmationBtn.click();
    }

    public void MakeScreenshot() throws IOException {
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String filePath = "coderslab/storeshop/screenshots/order.jpg";
        FileUtils.copyFile(screenshot, new File("D:\\szkola\\tester_aut\\praca_fin1\\src\\test\\java\\pl\\coderslab\\storeshop\\screenshots\\order.jpg"));
    }
}