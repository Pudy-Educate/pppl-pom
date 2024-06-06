package org.example.object;

import org.openqa.selenium.By;

public class HomeObject {

    public By getItem(String xPath){
        return By.xpath(xPath);
    }

    public By getCartBadge(){
        return By.className("shopping_cart_badge");
    }
}
