package model.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {
    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    @FindBy(xpath = "//div[@class='cart_item']")
    private List<WebElement> cartProductList;

    public CartPage (WebDriver driver) {
        super(driver);
    }
    public WebElement getCheckoutButton() {
    return checkoutButton;
    }
    public List<WebElement> getCartProductList() {
        return cartProductList;
    }
    public ShoppingInformationPage checkout() {
        checkoutButton.click();
        return new ShoppingInformationPage(driver);
    }
}
