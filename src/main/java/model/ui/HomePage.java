package model.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    @FindBy(id = "shopping_cart_container")
    private WebElement shoppingCart;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public WebElement getShoppingCart() {
        return shoppingCart;
    }
    public WebElement getAddOrRemoveButton(String productName) {
        String addToCartButtonXpath = String.
                format("//*[contains(text(), '%s')]//ancestor::*[@class='inventory_item']//child::button", productName);
        return driver.findElement(By.xpath(addToCartButtonXpath));
    }

    public CartPage openCart() {
        shoppingCart.click();
        return new CartPage(driver);
    }

}
