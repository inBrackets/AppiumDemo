package org.example;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


public class DriverProvider implements WebDriverProvider {

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();
        ConfigurationService.AndroidConfiguration androidConfiguration = new ConfigurationService().getAndroidConfiguration();
        options.setPlatformName(androidConfiguration.getPlatformName());
        options.setAutomationName(androidConfiguration.getAutomationName());
        options.setDeviceName(androidConfiguration.getDeviceName());
        File file = new File("apks/"+androidConfiguration.getApp());
        options.setApp(file.getAbsolutePath());
        options.setAppActivity(androidConfiguration.getAppActivity());
        options.setAppPackage(androidConfiguration.getAppPackage());
        options.autoGrantPermissions();

//        desiredCapabilities.setCapability("appium:appPackage", "com.swaglabsmobileapp");
//        desiredCapabilities.setCapability("appium:appActivity", "com.swaglabsmobileapp.MainActivity");
//        desiredCapabilities.setCapability("appium:autoGrantPermissions", "true");

        //AndroidDriver driver =
        try {
            return new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
