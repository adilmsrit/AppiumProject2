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

public class TestCase6_OperationsOnWebAndBackToNative extends baseForeCommerce {
/* Test Case automated below
* Verify if user can do operations on Web View and can navigate back to Native App if needed.
* Test Case is incomplete
* */
    @Test
    public void validateOrdeinCheckoutPage() throws MalformedURLException, InterruptedException {
        AndroidDriver<AndroidElement> driver = capabilities();
        driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Helllooo");
        driver.hideKeyboard();
        driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
        List<AndroidElement> AddToCartElements = driver.findElements(By.xpath("//*[@text='ADD TO CART']"));
        for (AndroidElement element : AddToCartElements) {
            element.click();
        }
        driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
        Thread.sleep(1500);
        driver.findElementById("com.androidsample.generalstore:id/btnProceed").click();

        Thread.sleep(2000);
        Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
            System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
        }

        driver.context("WEBVIEW_com.androidsample.generalstore");
        driver.findElement(By.name("q")).sendKeys("hello");





    }

}
