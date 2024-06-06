package org.example;

import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GoogleTest {
    WebDriver driver;
    @BeforeAll
    public void setup(){
        driver = new ChromeDriver();
        driver.get("https://google.com/");
    }

    @Test
    public void driverTest(){
        Searchpage searchpage = new Searchpage(driver);
        searchpage.setBar("ppp");
//        Resultpage resultpage = searchpage.search();
//        String title = resultpage.getWebTitle();
//        Assertions.assertTrue(title.contains("ppp"));

    }


    @AfterAll
    public void done(){
        driver.quit();
    }
}
