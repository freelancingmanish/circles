import org.testng.annotations.Test;
import pages.FaceBookAppLoginPage;
import pages.FbAppProfilePage;

import static pages.CirclesWebLoginPage.*;
import static pages.FaceWebHomePage.navigateToHomeAndPostAComment;
import static pages.FacebookWebLoginPage.loginToFacebook;
import static utils.DriverFactory.startAppiumServer;
import static utils.DriverFactory.stopAppiumServer;


public class CirclesAssignment {

    private String message = "Difficult Times Calls For Out Of Box Solutions " + getRandom();

    @Test(priority = 1)
    public void loginToCirclesWebsiteAndNavigateToFacebookTest() {
        loginToCirclesWebsite();
        navigateToBottomOfPage();
        launchFacebookWebPageFromCirclesSite();
    }

    @Test(priority = 2)
    public void loginToFacebookTest() {
        loginToFacebook("olamanishv@gmail.com", "M@n!s#1988");
    }

    @Test(priority = 3)
    public void postAMessageInFacebookTest() {
        navigateToHomeAndPostAComment(message);
    }

    @Test(priority = 4)
    public void loginToFacebookAppAndVerifyCommentTest() {
        startAppiumServer();
        new FaceBookAppLoginPage().launchAndLoginToFacebookApp("olamanishv@gmail.com", "M@n!s#1988");
        new FbAppProfilePage().navigateToProfilePageAndVerifyText(message);
        stopAppiumServer();
    }
}
