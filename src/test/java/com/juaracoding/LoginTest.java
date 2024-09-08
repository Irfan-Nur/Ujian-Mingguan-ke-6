package com.juaracoding;

import com.juaracoding.drives.DriverSingleton;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage = new LoginPage();

    public LoginTest (){
        driver = Hooks.driver;
    }

    @BeforeClass
    public void setUp() {
        driver.get(Constants.URL);
    }
    @AfterClass
    public void finish(){
        DriverSingleton.delay(5);
        DriverSingleton.closeObjectInstance();
    }
    @Test(priority = 4)
    public void testValidLogin (){
        loginPage.clearPassword();
        loginPage.clearUsername();
        DriverSingleton.delay(5);
        loginPage.login("standard_user","secret_sauce");
        Assert.assertEquals(loginPage.getTxtDashboard(),"Products");
        DriverSingleton.delay(5);
    }
    @Test(priority = 1)
    public void testInvalidLogin1 (){
        loginPage.clearPassword();
        loginPage.clearUsername();
        DriverSingleton.delay(3);
        loginPage.login("standard_user", "");
        DriverSingleton.delay(5);
        Assert.assertEquals(loginPage.getTxtPasswordRequired(),"Epic sadface: Password is required");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/");
    }
    @Test(priority = 2)
    public void testInvalidLogin2 (){
        loginPage.clearPassword();
        loginPage.clearUsername();
        DriverSingleton.delay(3);
        loginPage.login("", "secret_sauce");
        DriverSingleton.delay(5);
        Assert.assertEquals(loginPage.getTxtUsernamedRequired(),"Epic sadface: Username is required");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/");
    }
    @Test(priority = 3)
    public void testInvalidLogin3 (){
        loginPage.clearPassword();
        loginPage.clearUsername();
        DriverSingleton.delay(3);
        loginPage.login("admin", "4dmin*123");
        DriverSingleton.delay(5);
        Assert.assertEquals(loginPage.getTxtUsernameAndPasswordNotMatch(),"Epic sadface: Username and password do not match any user in this service");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/");
    }
    @Test(priority = 5)
    public void testRequired (){
        loginPage.logout();
        DriverSingleton.delay(2);
    }
}
