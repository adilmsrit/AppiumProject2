import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import org.openqa.selenium.WebElement;
import java.net.MalformedURLException;
import java.time.Duration;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class AppiumGestures extends base {
    public static void main(String... args) throws MalformedURLException {
        AndroidDriver<AndroidElement> driver = capabilities("browser");
        driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
        WebElement expandableList = driver.findElementByAndroidUIAutomator("text(\"Expandable Lists\")");
        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(tapOptions().withElement(element(expandableList))).perform();
        driver.findElementByAndroidUIAutomator("text(\"1. Custom Adapter\")").click();
        WebElement peopelname = driver.findElementByAndroidUIAutomator("text(\"People Names\")");
        touchAction.longPress(longPressOptions()
                .withElement(element(peopelname)).withDuration(Duration.ofSeconds(4))).release().perform();


    }
}
