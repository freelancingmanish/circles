package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WebSupport;


public class FaceWebHomePage extends WebSupport {

    private static WebDriver driver = getChromeDriver();

    public static void navigateToHomeAndPostAComment(String message) {
        driver.findElement(By.xpath(".//*[@id='u_0_c']/a")).click();
        sleep(3000);
        driver.findElement(By.xpath(".//span[contains(text(), 'Compose Post')]")).click();
        sleep(2000);
        WebElement element = driver.findElement(By.xpath(".//*[@class='_5yk2']"));
        element.click();
        element.sendKeys(message);
        driver.findElement(By.xpath(".//span[contains(text(), 'Post')]")).click();
        driver.findElement(By.className("_1mf7")).click();
    }
}
