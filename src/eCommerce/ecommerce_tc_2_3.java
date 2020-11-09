package eCommerce;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class ecommerce_tc_1 extends baseForeCommerce {

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
        System.out.println(driver.findElementsById("com.androidsample.generalstore:id/productImage").size());
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0))"));
        int count = driver.findElementsById("com.androidsample.generalstore:id/productName").size();

        for (int i = 0; i < count; i++) {
            String text = driver.findElementsById("com.androidsample.generalstore:id/productName").get(i).getText();
            if (text.equalsIgnoreCase("Jordan 6 Rings")) {
                driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(i).click();
                break;
            }
        }
        driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();

        String textFromCart = driver.findElement(By.xpath("//*[@resource-id='com.androidsample.generalstore:id/productName']")).getText();
        Assert.assertEquals("Jordan 6 Rings", textFromCart);
    }
}
