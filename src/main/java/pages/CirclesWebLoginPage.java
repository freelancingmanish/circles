package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import utils.WebSupport;


public class CirclesWebLoginPage extends WebSupport {

    private static WebDriver driver = getChromeDriver();

    public static void loginToCirclesWebsite() {
        driver.get("https://shop.circles.life/login");
        driver.findElement(By.name("email")).sendKeys("manishverma@dispostable.com");
        driver.findElement(By.name("password")).sendKeys("manishverma");
        driver.findElement(By.xpath(".//button[contains(text(), 'Sign In')]")).click();
    }

    public static void navigateToBottomOfPage() {
        sleep(2000);
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public static void launchFacebookWebPageFromCirclesSite() {
        driver.findElements(By.xpath(".//*[@id='st-container']//a[1]/img")).get(1).click();
    }
}
