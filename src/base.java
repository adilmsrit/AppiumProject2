import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class base {
    //Create a base class so that we can call this in every test case.
    public static AndroidDriver<AndroidElement> capabilities(String device) throws MalformedURLException {
        AndroidDriver<AndroidElement> driver;

        File f = new File("src");
        File fs = new File(f, "ApiDemos-debug.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();

        if (device.equals("emulator")) {
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "AdilEmulator");
        } else if (device.equals("real")) {
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
        }
        capabilities.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());

        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
}
