package eCommerce;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;

public class ecommerce_tc_4 extends baseForeCommerce {
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

        List<AndroidElement> AddToCartElements = driver.findElements(By.xpath("//*[@text='ADD TO CART']"));

        for (AndroidElement element : AddToCartElements) {
            element.click();
        }

        driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();

        Thread.sleep(2000);
        List<AndroidElement> amountOfItemsInCart = driver.findElementsById("com.androidsample.generalstore:id/productPrice");

        Double total = 0.00;
        for (AndroidElement items : amountOfItemsInCart) {
            total = total + Double.parseDouble(items.getText().substring(1));
        }

        double totalFromApp = Double.parseDouble(driver.findElementById("com.androidsample.generalstore:id/totalAmountLbl").getText().substring(1));

        Assert.assertEquals(total, totalFromApp);
    }

    public int[] front11(int[] a, int[] b) {

        int[] result = new int[2];

        if (a.length == 0) result[0] = b[0];
        else if (b.length == 0) result[0] =  a[0];
        else {
            result[0] = a[0];
            result[1] = b[0];
        }

        return result;

        WebElement checkBox = driver.findElementByClassName("android.widget.CheckBox");

        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(checkBox))).perform();

        WebElement terms = driver.findElementById("com.androidsample.generalstore:id/termsButton");
        touchAction.longPress(LongPressOptions.longPressOptions()
                .withElement(ElementOption.element(terms))
                .withDuration(Duration.ofSeconds(5))).perform();
        driver.findElementById("android:id/button1").click();
        Thread.sleep(1000);
        driver.findElementById("com.androidsample.generalstore:id/btnProceed").click();

    }

}
