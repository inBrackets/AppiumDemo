package org.example.screens;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.appium.selector.CombinedBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.WaitOptions;
import lombok.extern.slf4j.Slf4j;
import org.example.dto.Item;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.Wait;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.appium.ScreenObject.screen;
import static com.codeborne.selenide.appium.SelenideAppium.$;
import static java.lang.String.format;

@Slf4j
public class ProductsListScreen {

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Item']")
    private ElementsCollection products;

    public ProductsListScreen logProductsCount() {
        log.info("There are {} products", products.size());
        return this;
    }

    public ItemDetailsScreen openItemDetails(Item item) {
        String xpathPlaceholder = "//android.widget.TextView[@content-desc='test-Item title' and contains(@text, '%s')]";
        CombinedBy chosenItem = CombinedBy.android(By.xpath(format(xpathPlaceholder, item.getName())));
        sleep(1000);
        if($(chosenItem).isDisplayed()) {
            $(chosenItem).click();
        } else {
            $(chosenItem).scrollTo().click();
        }
        return screen(ItemDetailsScreen.class);
    }
}
