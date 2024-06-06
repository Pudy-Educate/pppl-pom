package org.example.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginObject {
    WebDriver driver;
    public LoginObject(WebDriver driver){
        this.driver=driver;
    }

    public By getUsername(){
        return By.id("user-name");
    }

    public By getPassword(){
        return By.id("password");
    }

    public By getLoginBtn(){
        return By.id("login-button");
    }
}
