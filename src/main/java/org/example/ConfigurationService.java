package org.example;

import lombok.Getter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationService {

    final private static String RESOURCE_FILE_NAME = "driver.properties";
    private static Properties configuration = new Properties();
    ConfigurationService() {
        InputStream inputStream = ConfigurationService.class
                .getClassLoader()
                .getResourceAsStream(RESOURCE_FILE_NAME);
        try {
            configuration.load(inputStream);
            inputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public AndroidConfiguration getAndroidConfiguration() {
        return new AndroidConfiguration();
    }

    @Getter
    static class AndroidConfiguration {
        private String platformName = configuration.getProperty("android.platformName");
        private String automationName = configuration.getProperty("android.automationName");
        private String deviceName = configuration.getProperty("android.deviceName");
        private String app = configuration.getProperty("android.app");
        private String appActivity = configuration.getProperty("android.appActivity");
        private String appPackage = configuration.getProperty("android.appPackage");
    }
}
