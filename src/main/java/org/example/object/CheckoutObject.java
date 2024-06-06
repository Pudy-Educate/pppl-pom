package org.example.object;

import org.openqa.selenium.By;

public class CheckoutObject {
    public By getFirstName(){
        return By.id("first-name");
    }

    public By getLastName(){
        return By.id("last-name");
    }
    public By getPostalCode(){
        return By.id("postal-code");
    }

    public By getItem(String xPath){
        return By.xpath(xPath);
    }

    public By getCheckoutFinishBtn(){
        return By.id("finish");
    }
    public By getCheckoutContinueBtn(){
        return By.id("continue");
    }
}
