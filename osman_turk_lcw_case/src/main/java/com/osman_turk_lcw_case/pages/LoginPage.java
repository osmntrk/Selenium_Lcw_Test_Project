package com.osman_turk_lcw_case.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void LoginProcess(){
        //Login and check the site
        WebElement Email=this.webDriver.findElement(By.id("LoginEmail"));
        WebElement Password=this.webDriver.findElement(By.id("Password"));
        WebElement EnteranceButton=this.webDriver.findElement(By.id("loginLink"));
        Email.sendKeys("osmanturk41@hotmail.com");
        Password.sendKeys("123456As");
        EnteranceButton.click();
        if (webDriver.getCurrentUrl().contains("https://www.lcwaikiki.com/tr-TR/TR")) {
            System.out.println("website has been logged");
        } else {
            throw new WebDriverException("Webpage did not opened");
        }
    }
    public boolean checkLogin(){
        WebElement control = webDriver.findElement(By.className("header-icon-label"));
        return control.getAttribute("innerText").equals("Hesabım");
    }
}
