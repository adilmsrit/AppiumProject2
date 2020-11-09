import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.time.Duration;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class SwipeDemo extends base {
    public static void main(String... args) throws MalformedURLException {
        AndroidDriver<AndroidElement> driver = capabilities("emulator");

        driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
        driver.findElementByAndroidUIAutomator("text(\"Date Widgets\")").click();
        driver.findElementByAndroidUIAutomator("text(\"2. Inline\")").click();

        driver.findElementByXPath("//*[@content-desc='9']").click();

        TouchAction touchAction = new TouchAction(driver);
//long press for 2 second and move to another element and release it.

        WebElement startElement = driver.findElementByXPath("//*[@content-desc='15']");
        WebElement endElement = driver.findElementByXPath("//*[@content-desc='45']");

        touchAction.longPress(longPressOptions().
                withElement(element(startElement)).
                withDuration(Duration.ofSeconds(3))).moveTo(element(endElement)).release().perform();



    }
}
