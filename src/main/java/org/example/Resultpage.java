package org.example;

import org.openqa.selenium.WebDriver;

public class Resultpage {
    WebDriver driver;
    public Resultpage(WebDriver driver){
        this.driver=driver;
    }

    public String getWebTitle(){
        return driver.getTitle();
    }

}
