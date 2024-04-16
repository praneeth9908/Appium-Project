package io.appium.pages;

import io.appium.base.BaseClass;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.Collections;

public class HomePage extends BaseClass {

    @FindBy(className = "android.widget.EditText")
    WebElement search;
    public HomePage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchProduct(String query) {
        tap(450, 300);
        search.sendKeys(query);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    private void tap(int x, int y){
        Point point = new Point(x, y);
        PointerInput finger = new PointerInput(
                PointerInput.Kind.TOUCH,
                "finger"
        );
        Sequence sequence = new Sequence(finger, 1);
        sequence.addAction(finger.createPointerMove(
                Duration.ofMillis(0),
                PointerInput.Origin.viewport(),
                point
        ));
        sequence.addAction(finger.createPointerDown(
                PointerInput.MouseButton.LEFT.asArg()
        ));
        sequence.addAction(new Pause(finger, Duration.ofMillis(100)));
        sequence.addAction(finger.createPointerUp(
                PointerInput.MouseButton.LEFT.asArg()
        ));

        driver.perform(Collections.singletonList(sequence));
    }
}
