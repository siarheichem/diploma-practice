package model.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingInformationPage extends BasePage {

    @FindBy(xpath = ".//*[@id='first-name']")
    public WebElement firstNameInput;

    @FindBy(xpath = ".//*[@id='last-name']")
    public WebElement lastNameInput;

    @FindBy(xpath = ".//*[@id='postal-code']")
    public WebElement postalCodeInput;

    @FindBy(xpath = ".//*[@id='continue']")
    public WebElement continueButton;

    public ShoppingInformationPage (WebDriver driver) {
        super(driver);
    }

    public OrderDetailsPage next (String firstName, String lastName, String postalCode) {
        firstNameInput.click();
        firstNameInput.sendKeys(firstName);
        lastNameInput.click();
        lastNameInput.sendKeys(lastName);
        postalCodeInput.click();
        postalCodeInput.sendKeys(postalCode);
        continueButton.click();
        return new OrderDetailsPage(driver);
    }

}
