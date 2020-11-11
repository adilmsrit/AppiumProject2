package eCommerce;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class ecommerce_tc_4 extends baseForeCommerce {
/* Test Case automated below
* Validate the total Amount displayed in the checkout page matches with the sum of products selected for shopping.
*
* */
    @Test
    public void validateOrdeinCheckoutPage() throws MalformedURLException {
        AndroidDriver<AndroidElement> driver = capabilities();
        driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Helllooo");
        driver.findElementByXPath("//*[@text='Female']").click();
        driver.hideKeyboard();
        driver.findElementById("android:id/text1").click();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));")
                .click();
        driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();

//        WebElement AddToCartElements = driver.findElements(By.xpath("//*[@text='']"));

        driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();

    }
}
