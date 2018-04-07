package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class FaceBookAppLoginPage extends BaseAppPage {

    @FindBy(id = "login_username")
    private WebElement loginEmail;
    @FindBy(id = "login_password")
    private WebElement loginPassword;
    @FindBy(id = "login_login")
    private WebElement loginButton;

    public FaceBookAppLoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void launchAndLoginToFacebookApp(String username, String password) {
        sleepInSeconds(7);
        loginEmail.sendKeys(username);
        loginPassword.click();
        loginPassword.sendKeys(password);
        loginButton.click();
    }
}
