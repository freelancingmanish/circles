package pages;
import io.appium.java_client.android.AndroidDriver;

import static utils.DriverFactory.getDriver;


class BaseAppPage {

    AndroidDriver driver;

    BaseAppPage() {
        this.driver = getDriver();
    }

    void sleepInSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
