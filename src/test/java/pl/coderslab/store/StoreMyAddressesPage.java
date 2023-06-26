package pl.coderslab.store;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class StoreMyAddressesPage {
    private final WebDriver driver;

    @FindBy(xpath = "//span[normalize-space()='Create new address']")
    private WebElement newAddressBtn;

    @FindBy(className = "address")
    private List<WebElement> addresses;

    public StoreMyAddressesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public StoreNewAddressPage addNewAddress() {
        newAddressBtn.click();
        return new StoreNewAddressPage(driver);
    }

    public boolean addressIsVisible() {
        return addresses.size() > 0;
    }

    public String getFirstAddressAsText() {
        WebElement address = addresses.get(0);
//        String aliasText = address.findElement(By.xpath("//h4[normalize-space()='Alias']")).getText(); // sam alias tez jest ok
        String addressText = address.findElement(By.className("address-body")).getText();
        return String.join("\n", addressText);
    }

    public void removeTheAddress() {
        for (WebElement address : addresses) {
            address.findElement(By.xpath("/html/body/main/section/div/div/section/div[3]/article/div[2]/a[2]/span")).click();
            driver.switchTo().alert().accept();
        }
    }
}