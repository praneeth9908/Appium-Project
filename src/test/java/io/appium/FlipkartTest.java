package io.appium;

import io.appium.base.BaseClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.pages.HomePage;
import io.appium.pages.ProductPage;
import io.appium.pages.SearchResultsPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;


public class FlipkartTest {
    AndroidDriver driver;
    BaseClass baseClass = new BaseClass();
    HomePage homePage;
    SearchResultsPage searchResultsPage;
    ProductPage productPage;
    private final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeMethod
    public void setUp() throws IOException {
        logger.info("Starting Setting Caps");
        driver = baseClass.setCaps();
        logger.info("Completed Setting Caps. Also Started driver");
    }

    @Test(dataProvider = "searchData")
    public void testSearchAndAddToCart(String searchQuery) {
        // Perform search
        logger.info("Started Searing for Product");
        homePage = new HomePage(driver);
        homePage.searchProduct(searchQuery);
        logger.info("Selecting the first product from the result list");
        // Select the first product from the list
        searchResultsPage = new SearchResultsPage(driver);
        searchResultsPage.selectFirstProduct();
        logger.info("Adding product to cart");
        // Add product to cart
        productPage = new ProductPage(driver);
        productPage.addToCart();
        logger.info("Product added to the cart");
    }

    @AfterMethod
    public void tearDown(){
        logger.info("Driver is going to Quit");
        baseClass.closeDriver();
        logger.info("Driver is terminated");
    }

    @DataProvider(name = "searchData")
    public Object[][] searchData() {
        Object[][] searchdata = new Object[3][1];
        searchdata[0][0] = "samsung mobiles";
        searchdata[1][0] = "samsung tvs";
        searchdata[2][0] = "samsung laptops";
        return searchdata;
    }
}
