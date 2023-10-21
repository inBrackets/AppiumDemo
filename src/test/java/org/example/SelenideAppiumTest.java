package org.example;

import com.codeborne.selenide.appium.SelenideAppium;
import com.codeborne.selenide.appium.selector.CombinedBy;
import io.appium.java_client.AppiumBy;
import org.example.dto.Item;
import org.example.screens.LoginScreen;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.appium.ScreenObject.screen;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class SelenideAppiumTest {

    @BeforeEach
    public void setUp() {

        // Configuration.browser = DriverProvider.class.getName(); // overridden by selenide.properties
        SelenideAppium.launchApp();

    }

    @ParameterizedTest(name = "Case {index}: itemDisplayName={0}")
    @MethodSource("dataSource")
    public void testAddingItemsToCart(String itemDisplayName, Item item) {
        LoginScreen loginScreen = screen(LoginScreen.class);
        loginScreen
                .inputUsername("standard_user")
                .inputPassword("secret_sauce")
                .submitCredentials()
                .openItemDetails(item)
                .goBackToTheItemList()
                .openItemDetails(item)
                .addAndGoToCart()
                .itemShouldBePresentInCart(item);
    }

    @AfterEach
    public void tearDown() {
        CombinedBy menuIcon = CombinedBy.android(AppiumBy.xpath("//android.view.ViewGroup[@content-desc='test-Menu']/android.view.ViewGroup/android.widget.ImageView"));
        sleep(500);
        $(menuIcon).click();

        CombinedBy resetAppStateButton = CombinedBy.android(AppiumBy.xpath("//android.view.ViewGroup[@content-desc='test-RESET APP STATE']/android.widget.TextView"));
        sleep(500);
        $(resetAppStateButton).click();

        sleep(500);
        $(menuIcon).click();

        CombinedBy logoutButton = CombinedBy.android(AppiumBy.xpath("//android.view.ViewGroup[@content-desc='test-LOGOUT']/android.widget.TextView"));
        sleep(500);
        $(logoutButton).click();
    }

    private static Stream<Arguments> dataSource() {
        return Stream.of(
                Arguments.of("Sauce Labs Backpack", Item.builder().withName("Sauce Labs Backpack").build()),
                Arguments.of("Sauce Labs Bike Light", Item.builder().withName("Sauce Labs Bike Light").build()),
                Arguments.of("Sauce Labs Bolt T-Shirt", Item.builder().withName("Sauce Labs Bolt T-Shirt").build()),
                Arguments.of("Sauce Labs Fleece Jacket", Item.builder().withName("Sauce Labs Fleece Jacket").build()),
                Arguments.of("Sauce Labs Onesie", Item.builder().withName("Sauce Labs Onesie").build()),
                Arguments.of("Test.allTheThings() T-Shirt (Red)", Item.builder().withName("Test.allTheThings() T-Shirt (Red)").build())
        );
    }
}