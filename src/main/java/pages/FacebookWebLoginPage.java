package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WebSupport;

import java.util.ArrayList;


public class FacebookWebLoginPage extends WebSupport {

    private static WebDriver driver = getChromeDriver();

    public static void loginToFacebook(String username, String password) {
        ArrayList<String> browserTabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(browserTabs.get(1));
        driver.findElement(By.id("email")).sendKeys(username);
        driver.findElement(By.id("pass")).sendKeys(password);
        driver.findElement(By.id("u_0_3")).click();
    }
}
