import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class basics extends base {
    public static void main(String... args) throws MalformedURLException {
        AndroidDriver<AndroidElement> driver = capabilities("emulator");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
//        driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
//        driver.findElementById("android:id/checkbox").click();
//        driver.findElementByXPath("//android.widget.TextView[@text='WiFi settings']").click();
//        driver.findElementById("android:id/edit").sendKeys("AdilPasswordEntered");
//        driver.findElementByXPath("//android.widget.Button[@text='OK']").click();


//        driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
//        driver.findElementByAndroidUIAutomator("text(\"Animation\")").click();

       int size =  driver.findElementsByAndroidUIAutomator(" new UiSelector().clickable(true)").size();
        System.out.println("Size is : " + size);



    }
}
