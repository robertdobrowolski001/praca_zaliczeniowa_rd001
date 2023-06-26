package pl.coderslab.storeshop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopMyAccountPage {
    private final WebDriver driver;

    @FindBy(css = "#_desktop_logo")
    private WebElement storeBtn;

    @FindBy(css = "#_desktop_user_info > div > a.account > span")
    private WebElement userInfo;


    public ShopMyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getUserName(){
        return userInfo.getText();
    }

    public ShopShoppingPage goToShoppingPage() {
//        public StoreMyAddressesPage goToMyAddressesPage() {
        storeBtn.click();
        return new ShopShoppingPage(driver);
//        return new StoreMyAddressesPage(driver);
    }
}
