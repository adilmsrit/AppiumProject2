package eCommerce;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
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
        driver.findElementByXPath("//*[@text='Female']").click();
        driver.hideKeyboard();
        driver.findElementById("android:id/text1").click();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));")
                .click();
        driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();

        List<AndroidElement> AddToCartElements = driver.findElements(By.xpath("//*[@text='ADD TO CART']"));

        for (AndroidElement element : AddToCartElements) {
            element.click();
        }

//        WebElement AddToCartElements = driver.findElements(By.xpath("//*[@text='']"));

        driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();

        Thread.sleep(2000);
        List<AndroidElement> amountOfItemsInCart = driver.findElementsById("com.androidsample.generalstore:id/productPrice");
        System.out.println(amountOfItemsInCart.size());

        Double total = 0.00;
        for (AndroidElement items : amountOfItemsInCart) {
            total = total + Double.parseDouble(items.getText().substring(1));
        }

        double totalFromApp = Double.parseDouble(driver.findElementById("com.androidsample.generalstore:id/totalAmountLbl").getText().substring(1));

        Assert.assertEquals(total, totalFromApp);

    }
}
