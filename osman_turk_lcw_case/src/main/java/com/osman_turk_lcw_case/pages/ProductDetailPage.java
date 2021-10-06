package com.osman_turk_lcw_case.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class ProductDetailPage extends BasePage{
    public float price = 0;
    public ProductDetailPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void run(){
        Random rnd=new Random();

        // Size is selected. (Must be chosen size)
        //Because of one more  options  about product's colour,Firstly choose colour and then choose size.
        WebElement optionSize =this.webDriver.findElement(By.id("option-size"));
        List<WebElement> otherColors = this.webDriver.findElements(By.className("dv-look-list"));

        if(otherColors.size()>0) {
            int index3=rnd.nextInt(otherColors.size());
            // Color selection has been made
            WebElement color= otherColors.get(index3);
            //product price taken
            WebElement priceElement=color.findElement(By.className("option-single-cash"));
            String str = priceElement.getAttribute("innerText");
            String strArray[] = str.trim().split("\\s+");
            price = Float.parseFloat(strArray[0].replace(",","."));
            // Size list is opened
            WebElement dropDownOpener = color.findElement(By.className("sizeHeight"));
            dropDownOpener.click();
            WebElement optionSize2=color.findElement(By.id("option-size"));
            List<WebElement> sizes =  optionSize2.findElements(By.tagName("a"));

            int index2=rnd.nextInt(sizes.size());
            // Size selection has been made
            WebElement selectSize = sizes.get(index2);
            selectSize.click();
            WebElement sizeAndCart=color.findElement(By.className("sizeAndCart"));
            List<WebElement> sizeAndCartA = sizeAndCart.findElements(By.tagName("a"));
            //product is added to cart
            sizeAndCartA.get(sizeAndCartA.size() - 1).click();

        }
        else if (optionSize!=null){
            WebElement priceElement=this.webDriver.findElement(By.className("price"));
            String str = priceElement.getAttribute("innerText");
            String strArray[] = str.trim().split("\\s+");
            price = Float.parseFloat(strArray[0].replace(",","."));
            // if there is only one color, only the size is selected
            List<WebElement> sizes =  optionSize.findElements(By.tagName("a"));
            int index2=rnd.nextInt(sizes.size());
            sizes.get(index2).click();
            //product is added to cart
            WebElement productbutton=this.webDriver.findElement(By.id("pd_add_to_cart"));
            productbutton.click();
        }
        System.out.println(price == 0 ? "nbull":price);


    }
}
