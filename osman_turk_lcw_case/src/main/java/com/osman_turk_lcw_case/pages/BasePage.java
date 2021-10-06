package com.osman_turk_lcw_case.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BasePage {

    public WebDriver webDriver;
    public BasePage(WebDriver webDriver)
    {
        this.webDriver = webDriver;
    }
    public void openWebsite(){
        this.webDriver.get("https://www.lcwaikiki.com/tr-TR/TR");
        System.out.println("Website is opened");

    }
    public boolean checkUrl(String url ){
        String URL = webDriver.getCurrentUrl();
        return url.equals(URL);

    }

}
