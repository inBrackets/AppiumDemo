## Setup requirements
* Android Studio with device manager
  *  Android Virtual Device: Pixel 6 Android 8.1 API 27
* Appium cmd installed via npm and uiautomator2 driver
* Appium inspector with following session: 
``` 
  {
      "platformName": "android",
      "appium:platformVersion": "8.1.0",
      "appium:deviceName": "Pixel_6_API_27",
      "appium:automationName": "UiAutomator2",
      "appium:app": "C:\\[PATH_TO_APK]\\Android.SauceLabs.Mobile.Sample.app.2.7.1.apk",
      "appium:appActivity": "com.swaglabsmobileapp.MainActivity",
      "appium:appPackage": "com.swaglabsmobileapp",
      "appium:autoGrantPermissions": "true"
  } 
  ```
* SauceLabs Mobile Sample app 2.7.1