package pl.coderslab.store;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StoreAuthPage {
    public final WebDriver driver;

//    @FindBy(id = "email_create")
//    private WebElement newUserEmailInput;
//
//    @FindBy(id = "SubmitCreate")
//    private WebElement createNewAccountBtn;

    @FindBy(name = "email")
    private WebElement loginEmailInput;

    @FindBy(id = "field-password")
    private WebElement loginPasswdInput;

    @FindBy(id = "submit-login")
//    @FindBy(className = "user-info")
    private WebElement loginBtn;

//    @FindBy(css = "a[title='Home']")
//    private WebElement homeBtn;


    public StoreAuthPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements( driver, this);
    }

    public StoreMyAccountPage loginAs(String email, String passwd){
        loginEmailInput.clear();
        loginEmailInput.sendKeys(email);

        loginPasswdInput.clear();
        loginPasswdInput.sendKeys(passwd);

        loginBtn.click();
        return new StoreMyAccountPage(driver);

    }
}
