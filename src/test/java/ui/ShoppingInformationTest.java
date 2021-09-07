package ui;

import model.ui.CartPage;
import model.ui.HomePage;
import model.ui.OrderDetailsPage;
import model.ui.ShoppingInformationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoppingInformationTest extends BaseTest {

    private static final String USRNAME = "standard_user";
    private static final String PSWRD = "secret_sauce";
    private static final String PRODUCT_NAME = "Sauce Labs Backpack";
    public static final String FRSTNAME = "Ken";
    public static final String LSTNAME = "Miles";
    public static final String PSTLCODE = "12345";

    @Test
    public void ShoppingInformationTest () {
        HomePage homePage = loginPage.login(USRNAME, PSWRD);
        homePage.getAddOrRemoveButton(PRODUCT_NAME).click();
        CartPage cartPage = homePage.openCart();
        ShoppingInformationPage shoppingInformationPage = cartPage.checkout();
        OrderDetailsPage orderDetailsPage = shoppingInformationPage.next(FRSTNAME,LSTNAME,PSTLCODE);
        Assert.assertEquals(orderDetailsPage.getProductName().getText(),PRODUCT_NAME);
        Assert.assertEquals(orderDetailsPage.getProductPrice().getText(),"$29.99");

    }

}
