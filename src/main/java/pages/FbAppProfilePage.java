package pages;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.testng.Assert.assertTrue;


public class FbAppProfilePage extends BaseAppPage {

    @FindBy(id = "primary_named_button")
    private WebElement skipButton;
    @FindBy(id = "title")
    private WebElement titleText;
    @FindBy(id = "button2")
    private WebElement skipAgainButton;
    @FindBy(id = "dbl_off")
    private WebElement oneTapLoginNotNow;
    @FindBy(id = "feed_composer_profile_image")
    private WebElement profileImage;
    @FindBy(id = "standard_header_title")
    private WebElement myName;
    @FindBy(id = "feed_story_message")
    private List<WebElement> myFBFeed;

    public FbAppProfilePage() {
        PageFactory.initElements(driver, this);
    }

    private void skipFindFriends() {
        sleepInSeconds(11);
        if (titleText.getText().equalsIgnoreCase("Find Friends")) {
            skipButton.click();
            skipAgainButton.click();
        } else if (titleText.getText().equalsIgnoreCase("Log In With One Tap")) {
            oneTapLoginNotNow.click();
        }
    }

    public void navigateToProfilePageAndVerifyText(String message) {
        skipFindFriends();
        sleepInSeconds(3);
        profileImage.click();
        sleepInSeconds(2);
        new TouchAction(driver).longPress(driver.findElement(By.id("timeline_intro_card_add_label"))).moveTo(driver.findElement(By.id("search_edit_text"))).release().perform();
        WebElement post = driver.findElement(By.xpath("//*[contains(@content-desc,'" + message + "')]"));
        assertTrue(post.isDisplayed(), "Message Not Posted");
    }
}
