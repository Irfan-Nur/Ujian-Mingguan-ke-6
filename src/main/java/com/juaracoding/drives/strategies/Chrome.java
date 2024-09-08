package com.juaracoding.drives.strategies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chrome implements DriverStrategy {

    @Override
    public WebDriver setStrategy () {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\irfan\\Documents\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("--no-sandboox");
        return new ChromeDriver(options);
    }
}
