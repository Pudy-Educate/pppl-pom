package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Searchpage {
    private By bar = new By.ById("APjFqb");
    private By btn = new By.ByName("btnK");
    WebDriver driver;
    public Searchpage(WebDriver driver){
        this.driver=driver;
    }

    public void setBar(String text){
        driver.findElement(bar).sendKeys(text);
    }
    public void search(){
    WebElement button = driver.findElement(btn);
    button.submit();
    }


}
