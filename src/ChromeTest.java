import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import java.net.MalformedURLException;

public class ChromeTest extends baseChromeBrowser {
    public static void main(String... args) throws MalformedURLException {
        AndroidDriver<AndroidElement> driver = capabilities();
       driver.get("https://github.com/appium/appium/blob/master/docs/en/writing-running-appium/web/chromedriver.md");


    }
}
