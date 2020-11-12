package eCommerce;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class HybridScenario_1 extends baseForeCommerce {
/* Test Case automated below
* Validate the total Amount displayed in the checkout page matches with the sum of products selected for shopping.
*
* */
    @Test
    public void validateOrdeinCheckoutPage() throws MalformedURLException, InterruptedException {
        AndroidDriver<AndroidElement> driver = capabilities();
        driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Helllooo");
        driver.hideKeyboard();
        driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();

        Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
            System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
        }

    }

}
