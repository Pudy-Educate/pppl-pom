package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public WebElement waitUntilVisible(By by) throws InterruptedException{
        Thread.sleep(1000);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void verifyElementVisible(By by) throws InterruptedException{
        waitUntilVisible(by).isDisplayed();
    }

    public void click(By by) throws InterruptedException{
        waitUntilVisible(by).click();
    }

    public void inputText(By by, String text)throws InterruptedException{
        waitUntilVisible(by).sendKeys(text);
    }

}
