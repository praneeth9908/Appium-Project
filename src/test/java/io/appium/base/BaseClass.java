package io.appium.base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;

public class BaseClass {
    public AndroidDriver driver;

    public AndroidDriver setCaps() throws IOException {
        UiAutomator2Options caps = new UiAutomator2Options();
        // Set up desired capabilities for Appium
        caps.setDeviceName("Android Device");
        caps.setPlatformName("Android");
        caps.setPlatformVersion("13.0");
        caps.setUdid("1361521842000MR");
        caps.setAppPackage("com.flipkart.android");
        caps.setAppActivity(".SplashActivity");
        caps.setNoReset(true);

        // Initialize the driver
        this.driver = new AndroidDriver(new URL("http://localhost:4723/"), caps);
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Initialize elements using Page Factory
        return driver;
    }

    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
