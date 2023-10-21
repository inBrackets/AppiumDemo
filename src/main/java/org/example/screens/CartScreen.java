package org.example.screens;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.appium.SelenideAppium;
import com.codeborne.selenide.appium.selector.CombinedBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.example.dto.Item;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.appium.ScreenObject.screen;
import static java.lang.String.format;

public class CartScreen {

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='test-CONTINUE SHOPPING']/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "here goes xpath for iOS app")
    private WebElement continueShoppingButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='test-CHECKOUT']/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "here goes xpath for iOS app")
    private WebElement checkoutButton;

    public CheckoutScreen checkoutCart() {
        $(checkoutButton).scrollTo().click();
        return screen(CheckoutScreen.class);
    }

    public CartScreen itemShouldBePresentInCart(Item item) {
        String xpathPlaceholder = "//android.view.ViewGroup[@content-desc='test-Description']/android.widget.TextView[contains(@text, '%s')]";
        CombinedBy chosenItem = CombinedBy.android(By.xpath(format(xpathPlaceholder, item.getName())));
        SelenideAppium.$(chosenItem).shouldBe(visible);
        return this;
    }
}


