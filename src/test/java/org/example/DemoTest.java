package org.example;

import org.example.object.CheckoutObject;
import org.example.object.HomeObject;
import org.example.object.LoginObject;
import org.example.pages.BasePage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DemoTest {
    WebDriver driver ;
    LoginObject login;
    HomeObject home;
    BasePage page;
    CheckoutObject checkoutObject;
    @BeforeAll
    void setup(){
        this.driver = new FirefoxDriver();
        driver.get("https://www.saucedemo.com/");

    }
    @Order(1)
    @Test
    public void testLogin() throws InterruptedException {
        login = new LoginObject(driver);
        home = new HomeObject();
        page = new BasePage(driver,new WebDriverWait(driver, Duration.ofSeconds(2)));

        page.inputText(login.getUsername(),"standard_user");
        page.inputText(login.getPassword(),"secret_sauce");
        page.click(login.getLoginBtn());
        page.verifyElementVisible(home.getItem("//*[@id=\"header_container\"]/div[2]/span"));
    }

    @Order(2)
    @Test
    public void testAddToCart() throws InterruptedException {
        By addToCartButton = home.getItem("//*[@id=\"add-to-cart-sauce-labs-backpack\"]");
        By title = home.getItem("//*[@id=\"item_4_title_link\"]/div");

        page.click(addToCartButton);
        page.verifyElementVisible(home.getCartBadge());

        page.click(home.getItem("//*[@id=\"shopping_cart_container\"]/a"));
        By titleOnCart = home.getItem("//*[@id=\"item_4_title_link\"]/div");
        page.verifyElementVisible(titleOnCart);
        title.equals(titleOnCart);
    }
    @Test
    @Order(3)
    public void testCheckout() throws InterruptedException {
        By checkoutButton = home.getItem("//*[@id=\"checkout\"]");

        checkoutObject = new CheckoutObject();
        page.click(checkoutButton);
        page.verifyElementVisible(checkoutObject.getLastName());
        page.inputText(checkoutObject.getFirstName(),"Pudyasta");
        page.inputText(checkoutObject.getLastName(),"Pudyasta");
        page.inputText(checkoutObject.getPostalCode(),"55432");

        page.click(checkoutObject.getCheckoutContinueBtn());
        page.verifyElementVisible(checkoutObject.getItem("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[1]"));

        page.click(checkoutObject.getCheckoutFinishBtn());
        page.verifyElementVisible(checkoutObject.getItem("//*[@id=\"back-to-products\"]"));

    }


    @AfterAll
    void tearDown(){
        driver.quit();
    }
}
