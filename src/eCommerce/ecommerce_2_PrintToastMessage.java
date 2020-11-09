package eCommerce;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.net.MalformedURLException;

public class ecommerce_2_PrintToastMessage extends baseForeCommerce {

    public static void main(String... args) throws MalformedURLException {
        AndroidDriver<AndroidElement> driver = capabilities();
        driver.findElementByXPath("//*[@text='Female']").click();
        driver.hideKeyboard();
        driver.findElementById("android:id/text1").click();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));")
                .click();
        driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
        String toastmessage = driver.findElementByXPath("//android.widget.Toast[1]").getAttribute("name");
        System.out.println("toastmessage is as :-  " + toastmessage);

    }
}
