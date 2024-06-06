package org.example.stepDefinitions;

import dev.failsafe.internal.util.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Resultpage;
import org.example.Searchpage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchStep {
    WebDriver driver;

    @Given("User is on the google search page")
    public void user_is_on_the_google_search_page() {
        driver = new ChromeDriver();
        driver.get("https://google.com/");
    }
    @When("User try to search any keywords")
    public void user_try_to_search_any_keywords() {
        Searchpage searchpage = new Searchpage(driver);
        searchpage.setBar("ppp");
        searchpage.search();
    }
    @Then("User should be redirected to result page")
    public void user_should_be_redirected_to_result_page() {
        Resultpage resultpage = new Resultpage(driver);
        String title = resultpage.getWebTitle();
        Assertions.assertTrue(title.contains("ppp"));
    }

}
