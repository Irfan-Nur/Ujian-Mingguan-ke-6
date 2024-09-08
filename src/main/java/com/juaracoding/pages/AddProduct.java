package com.juaracoding.pages;

import com.juaracoding.drives.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddProduct {
    private WebDriver driver;
    public AddProduct(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[@id='add-to-cart-sauce-labs-backpack']")
    private WebElement addLabsBackpack;

    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
    private WebElement addLabsFleeceJacket;

    @FindBy(xpath = "//*[@id='shopping_cart_container']/a")
    private WebElement chart;

    @FindBy(id = "checkout")
    private WebElement checkout;

    @FindBy (id = "first-name")
    private WebElement fristName;

    @FindBy (id = "last-name")
    private WebElement lastName;

    @FindBy (id = "postal-code")
    private WebElement postalCode;

    @FindBy (id = "continue")
    private WebElement next;

    @FindBy (id = "finish")
    private WebElement end;

    @FindBy (xpath = "//*[@id='checkout_complete_container']/div")
    private WebElement txtOrderComplete;

    @FindBy (xpath = "//*[@id='checkout_info_container']/div/form/div[1]/div[4]/h3")
    private WebElement txtFirstnamedRequired;

    @FindBy (id = "back-to-products")
    private WebElement backHomePage;

    public void setAddLabsBackpack(){
        addLabsBackpack.click();
    }
    public void setAddLabsFleeceJacket(){
        addLabsFleeceJacket.click();
    }
    public void setChart(){
        chart.click();
    }
    public void setCheckout(){
        checkout.click();
    }
    public void setFirstName (String firstName){
        this.fristName.sendKeys(firstName);
    }
    public void setLastName (String lastName){
        this.lastName.sendKeys(lastName);
    }
    public void setPostalCode (String postalCode){
        this.postalCode.sendKeys(postalCode);
    }
    public void setNext(){
        next.click();
    }
    public void setEnd(){
        end.click();
    }
    public String getTxtOrderComplete(){
        return txtOrderComplete.getText();
    }
    public String getErrorMessage() {
        return txtFirstnamedRequired.getText();
    }
    public void setBackHomePage(){
        backHomePage.click();
    }

}
