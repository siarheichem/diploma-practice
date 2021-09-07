package model.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderDetailsPage extends BasePage {

    @FindBy (xpath = "//*[@class = 'inventory_item_name']")
    private WebElement productName;
    @FindBy (xpath = "//*[@class = 'inventory_item_price']")
    private WebElement productPrice;

    WebDriver driver;
    public OrderDetailsPage (WebDriver driver) {
        super(driver);
    }

    public WebElement getProductName() {
        return productName;
    }

    public WebElement getProductPrice() {
        return productPrice;
    }
}
