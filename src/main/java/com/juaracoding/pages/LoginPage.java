package com.juaracoding.pages;

import com.juaracoding.drives.DriverSingleton;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    public LoginPage() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement errorMessage;

    @FindBy (xpath = "//*[@id='header_container']/div[2]/span")
    private WebElement txtDashboard;

    @FindBy (xpath = "//*[@id='login_button_container']/div/form/div[3]/h3")
    private WebElement txtPasswordRequired;

    @FindBy (xpath = "//*[@id='login_button_container']/div/form/div[3]/h3")
    private WebElement txtUsernamedRequired;

    @FindBy (xpath = "//*[@id='login_button_container']/div/form/div[3]/h3")
    private WebElement txtUsernameAndPasswordNotMatch;

    @FindBy (id = "react-burger-menu-btn")
    private WebElement buttonSidebar;

    @FindBy (id = "logout_sidebar_link")
    private WebElement logoutSidebarLink;

    public void login(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();
    }
    public void logout(){
        DriverSingleton.delay(2);
        buttonSidebar.click();
        DriverSingleton.delay(3);
        logoutSidebarLink.click();
    }
    public void clearUsername(){
        username.sendKeys(Keys.CONTROL+"A");
        username.sendKeys(Keys.DELETE);
    }

    public void clearPassword(){
        password.sendKeys(Keys.CONTROL+"A");
        password.sendKeys(Keys.DELETE);
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }
    public String getTxtDashboard(){
        return txtDashboard.getText();
    }
    public String getTxtPasswordRequired(){
        return txtPasswordRequired.getText();
    }
    public String getTxtUsernamedRequired(){
        return txtUsernamedRequired.getText();
    }
    public String getTxtUsernameAndPasswordNotMatch(){
        return  txtUsernameAndPasswordNotMatch.getText();
    }
}