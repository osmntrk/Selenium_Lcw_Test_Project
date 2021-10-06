package com.osman_turk_lcw_case.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class FindingPage extends BasePage {
    public FindingPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void finding(){
        // type 'pantolon' in the search bar and search
        WebElement search=this.webDriver.findElement(By.id("search"));
        search.sendKeys("pantolon");
        search.sendKeys(Keys.ENTER);

        // scroll to the end of the page
        WebElement scroll=this.webDriver.findElement(By.cssSelector("body"));
        scroll.sendKeys(Keys.CONTROL,Keys.END);

        //click the see more button
        WebElement displayMore =this.webDriver.findElement(By.className("lazy-load-text"));
        displayMore.click();

        // A random product is selected
        List<WebElement> products = this.webDriver.findElements(By.className("product-item-wrapper"));
        Random rnd=new Random();
        int index= rnd.nextInt(products.size());
        WebElement RandomProduct = products.get(index);
        WebElement productA = RandomProduct.findElement(By.className("a_model_item"));
        productA.click();
    }
}
