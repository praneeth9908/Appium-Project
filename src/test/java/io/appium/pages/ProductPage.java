package io.appium.pages;

import io.appium.base.BaseClass;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BaseClass {

    By addToCartBtn = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(6)");
    public ProductPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void addToCart() {
        WebElement addToCartButtonLocator = driver.findElement(addToCartBtn);
        addToCartButtonLocator.click();
    }
}
