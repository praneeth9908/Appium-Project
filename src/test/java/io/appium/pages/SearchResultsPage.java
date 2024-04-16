package io.appium.pages;

import io.appium.base.BaseClass;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage extends BaseClass {
    @FindBy(xpath="(//android.widget.TextView[contains(@text,\"SAMSUNG\")])[1]")
    WebElement productLocator;
    public SearchResultsPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void selectFirstProduct() {
        productLocator.click();
    }
}
