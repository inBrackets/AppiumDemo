package org.example.screens;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.Wait;
import static com.codeborne.selenide.appium.ScreenObject.screen;


public class ItemDetailsScreen {
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='test-BACK TO PRODUCTS']/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "here goes xpath for iOS app")
    private WebElement backToProductsButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='test-ADD TO CART']/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "here goes xpath for iOS app")
    private WebElement addToCartButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Cart']/android.view.ViewGroup/android.widget.ImageView")
    private WebElement cartButton;

    public ProductsListScreen goBackToTheItemList() {
        $(backToProductsButton).click();
        return screen(ProductsListScreen.class);
    }

    public CartScreen addAndGoToCart() {
        Selenide.sleep(1000);
        $(addToCartButton).scrollTo().click();
        Selenide.sleep(2000);
        $(cartButton).click();
        return screen(CartScreen.class);
    }
}
