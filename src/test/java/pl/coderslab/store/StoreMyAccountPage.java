package pl.coderslab.store;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StoreMyAccountPage {
    private final WebDriver driver;

    @FindBy(css = "a[title='Addresses']")
    private WebElement myAddressesBtn;

    @FindBy(css = "#_desktop_user_info > div > a.account > span")
    private WebElement userInfo;


    public StoreMyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getUserName(){
        return userInfo.getText();
    }

    public StoreMyAddressesPage goToMyAddressesPage() {
        myAddressesBtn.click();
        return new StoreMyAddressesPage(driver);
    }
}
