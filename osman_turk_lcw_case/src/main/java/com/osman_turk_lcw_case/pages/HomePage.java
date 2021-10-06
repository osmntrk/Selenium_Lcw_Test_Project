package com.osman_turk_lcw_case.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{
    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void runLoginButton(){
       //Press enterence button
        WebElement goLoginButton=this.webDriver.findElement(By.id("header-user-section"));
        goLoginButton.click();
    }
}
