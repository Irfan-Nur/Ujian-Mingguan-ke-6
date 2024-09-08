package com.juaracoding.drives.strategies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox implements DriverStrategy {
    @Override
    public WebDriver setStrategy (){
        String path = "C:\\Users\\irfan\\Documents\\geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", path);
        return new FirefoxDriver();
    }
}
