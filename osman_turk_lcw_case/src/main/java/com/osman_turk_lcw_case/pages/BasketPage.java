package com.osman_turk_lcw_case.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasketPage extends BasePage{
    public BasketPage(WebDriver webDriver) {
        super(webDriver);
    }
    float cost;
    float basketPrice;
    public void compare(float cost){
        //Compare the price on the product page with the price in the basket.
        WebElement roadToBasket=this.webDriver.findElement(By.className("header-cart"));
        roadToBasket.click();
        WebElement priceElement2=this.webDriver.findElement(By.className("rd-cart-item-price"));
        String str = priceElement2.getAttribute("innerText");
        String strArray[] = str.trim().split("\\s+");
        float basketPrice = Float.parseFloat(strArray[0].replace(",","."));
        if (cost==basketPrice){
            System.out.println("The amount of the product is the same as the amount of the basket.");
        }
        else {
            System.out.println("The amount of the product and the amount of the basket are not the same");
        }





    }
    public boolean priceControl()
    {
        return cost == basketPrice;
    }
    public void incrementCount(){
        // It is verified that the product is 2 pieces by increasing the number
        WebElement productCountUp=this.webDriver.findElement(By.className("oq-up"));
        productCountUp.click();

    }
    public boolean incrementEquals2(){
        WebElement productCount=this.webDriver.findElement(By.className("item-quantity-input"));

        if (productCount.getAttribute("value").contains("2")) {
            System.out.println("The number of items in the basket is 2.");
            System.out.println("-----------------------------");
            return true;

        } else {
            System.out.println("The number of items in the basket is not 2.");
            return false;
        }
    }
    public void emptyBasket(){
        // Check that the product is empty by deleting it from the cart
        WebElement MakeİtClear = this.webDriver.findElement(By.className("cart-square-link"));
        MakeİtClear.click();
        WebElement MakeİtClear2 = this.webDriver.findElement(By.className("sc-delete"));
        MakeİtClear2.click();


    }
    public boolean basketIsEmpty(){
        WebElement cardEmptyTitle = this.webDriver.findElement(By.className("cart-empty-title"));
        if (cardEmptyTitle != null) {
            System.out.println("Basket is Empty");
            return true;

        } else {
            System.out.println("Basket is full");
            return false;
        }
    }
}
