package org.example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.MobileOptions;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SampleTest {

    @BeforeAll
    public static void setUp() throws MalformedURLException {

//        UiAutomator2Options options = new UiAutomator2Options()
//                .se
//                .setApp("C:\\repos\\AppiumDemo\\Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");

        MutableCapabilities desiredCapabilities = new MutableCapabilities();
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("appium:platformVersion", "8.1.0");
        desiredCapabilities.setCapability("appium:deviceName", "Pixel_6_API_27");
        desiredCapabilities.setCapability("appium:automationName", "UiAutomator2");
        desiredCapabilities.setCapability("appium:app", "C:\\repos\\AppiumDemo\\Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
        desiredCapabilities.setCapability("appium:appPackage", "com.swaglabsmobileapp");
        desiredCapabilities.setCapability("appium:appActivity", "com.swaglabsmobileapp.MainActivity");
        desiredCapabilities.setCapability("appium:autoGrantPermissions", "true");
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        AndroidDriver driver = new AndroidDriver(
                // The default URL in Appium 1 is http://127.0.0.1:4723/wd/hub
                new URL("http://127.0.0.1:4723"), desiredCapabilities
        );
        try {
            driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-Username\"]")).sendKeys("standard_user");
            driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-Password\"]")).sendKeys("secret_sauce");
            WebElement el = driver.findElement(AppiumBy.xpath( "//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]"));
            el.click();
            driver.getPageSource();
        } finally {
            driver.quit();
        }
    }

    @Test
    public void sampleTest() {

    }

    @AfterAll
    public static void tearDown() {

    }
}