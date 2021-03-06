package ui;

import model.ui.CartPage;
import model.ui.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Locale;

public class AddToCartTest extends BaseTest {

    private static final String USRNAME = "standard_user";
    private static final String PSWRD = "secret_sauce";
    private static final String PRODUCT_NAME = "Sauce Labs Backpack";

    @Test
    public void AddToCartTest() {
        HomePage homePage = loginPage.login(USRNAME, PSWRD);
        homePage.getAddOrRemoveButton(PRODUCT_NAME).click();
        Assert.assertEquals(homePage.getAddOrRemoveButton(PRODUCT_NAME).getText().toLowerCase(Locale.ROOT), "remove", "Product has not been added to cart");
        int quantity = Integer.valueOf(homePage.getShoppingCart().getText());
        Assert.assertEquals(quantity, 1, "Product has not been added to cart");
        CartPage cartPage = homePage.openCart();
        Assert.assertTrue(cartPage.getCheckoutButton().isDisplayed(), "You are not at the CartPage");
        Assert.assertEquals(cartPage.getCartProductList().size(), 1, "Your cart is empty");

    }
}
