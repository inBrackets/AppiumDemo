package org.example.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.appium.ScreenObject.screen;

public class LoginScreen {

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='test-Username']")
    @iOSXCUITFindBy(xpath = "here goes xpath for iOS app")
    private WebElement userNameInput;

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='test-Password']")
    private WebElement passwordInput;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='test-LOGIN']")
    private WebElement loginButton;

    public LoginScreen inputUsername(String username) {
        $(userNameInput).shouldBe(visible);
        userNameInput.sendKeys(username);
        return this;
    }

    public LoginScreen inputPassword(String password) {
        $(passwordInput).shouldBe(visible);
        passwordInput.sendKeys(password);
        return this;
    }

    public ProductsListScreen submitCredentials() {
        $(passwordInput).shouldBe(visible);
        loginButton.click();
        return screen(ProductsListScreen.class);
    }
}
