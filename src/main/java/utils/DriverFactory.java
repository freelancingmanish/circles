package utils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


public class DriverFactory {

    private static AndroidDriver driver;
    private static AppiumDriverLocalService service;

    public static AndroidDriver getDriver() {
        if (driver == null) {
            startDriver();
        }
        return driver;
    }

    private static void startDriver() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        setCapabilities(desiredCapabilities);
        try {
            driver = new AndroidDriver(new URL(Environment.url), desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private static void setCapabilities(DesiredCapabilities desiredCapabilities) {
        File appDir = new File("apps");
        desiredCapabilities.setCapability("app", new File(appDir, "fb.apk").getAbsolutePath());
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, Environment.platformVersion);
        desiredCapabilities.setCapability(MobileCapabilityType.UDID, Environment.udid);
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "AutomationDevice");
        desiredCapabilities.setCapability("appActivity", "com.facebook.katana.LoginActivity");
        desiredCapabilities.setCapability("appPackage", "com.facebook.katana");
        desiredCapabilities.setCapability(MobileCapabilityType.FULL_RESET, true);
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60000);
    }

    public static void startAppiumServer() {
        service = new AppiumServiceBuilder().usingPort(4723).build();
        service.start();
    }

    public static void stopAppiumServer() {
        if (service != null) {
            service.stop();
        } else
            System.out.println("Already Stopped");
    }
}
