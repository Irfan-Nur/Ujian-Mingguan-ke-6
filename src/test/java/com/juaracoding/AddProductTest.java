package com.juaracoding;

import com.juaracoding.drives.DriverSingleton;
import com.juaracoding.pages.AddProduct;
import com.juaracoding.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddProductTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private AddProduct addProduct;

    @BeforeClass
    public void setUp() {
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage();
        addProduct = new AddProduct();
    }
    @AfterClass
    public void finish(){
        DriverSingleton.delay(5);
        DriverSingleton.closeObjectInstance();
    }
    @Test
    public void testAddProduct (){
        loginPage.login("standard_user","secret_sauce");
        DriverSingleton.delay(1);
        addProduct.setAddLabsBackpack();
        DriverSingleton.delay(1);
        addProduct.setAddLabsFleeceJacket();
        DriverSingleton.delay(1);
        addProduct.setChart();
        DriverSingleton.delay(1);
        addProduct.setCheckout();
        DriverSingleton.delay(1);
        addProduct.setFirstName("Irfan");
        DriverSingleton.delay(1);
        addProduct.setLastName("Nur");
        DriverSingleton.delay(1);
        addProduct.setPostalCode("16969");
        DriverSingleton.delay(1);
        addProduct.setNext();
        DriverSingleton.delay(1);
        addProduct.setEnd();
        DriverSingleton.delay(1);
        Assert.assertEquals(addProduct.getTxtOrderComplete(),"Your order has been dispatched, and will arrive just as fast as the pony can get there!");
        addProduct.setBackHomePage();
    }
    @Test
    public void testEmptyYourInformation(){
        DriverSingleton.delay(1);
        addProduct.setAddLabsBackpack();
        DriverSingleton.delay(1);
        addProduct.setAddLabsFleeceJacket();
        DriverSingleton.delay(1);
        addProduct.setChart();
        DriverSingleton.delay(1);
        addProduct.setCheckout();
        DriverSingleton.delay(1);
        addProduct.setFirstName("");
        DriverSingleton.delay(1);
        addProduct.setLastName("");
        DriverSingleton.delay(1);
        addProduct.setPostalCode("");
        DriverSingleton.delay(1);
        addProduct.setNext();
        DriverSingleton.delay(3);
        Assert.assertEquals(addProduct.getErrorMessage(),"Error: First Name is required");
    }
}
