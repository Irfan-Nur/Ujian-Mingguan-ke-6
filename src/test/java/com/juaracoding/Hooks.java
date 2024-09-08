package com.juaracoding;

import com.juaracoding.drives.DriverSingleton;
import com.juaracoding.utils.Constants;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;

public class Hooks {
    public static WebDriver driver;
    @Before
    public void  setUp(){
        DriverSingleton.getInstance(Constants.CHROME);
        driver = DriverSingleton.getDriver();
    }
    @AfterAll
    public void finish(){
        DriverSingleton.delay(3);
        DriverSingleton.closeObjectInstance();
    }

}
