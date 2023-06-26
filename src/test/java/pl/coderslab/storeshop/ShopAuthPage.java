package pl.coderslab.storeshop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopAuthPage {
    public final WebDriver driver;

    @FindBy(name = "email")
    private WebElement loginEmailInput;

    @FindBy(id = "field-password")
    private WebElement loginPasswdInput;

    @FindBy(id = "submit-login")
    private WebElement loginBtn;


    public ShopAuthPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements( driver, this);
    }

    public ShopMyAccountPage loginAs(String email, String passwd){
        loginEmailInput.clear();
        loginEmailInput.sendKeys(email);

        loginPasswdInput.clear();
        loginPasswdInput.sendKeys(passwd);

        loginBtn.click();
        return new ShopMyAccountPage(driver);

    }
}
