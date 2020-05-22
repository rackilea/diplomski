package com.testerstories.learning.helpers;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class DriverFactory {
    private static Driver driver;

    @Before
    public void createDriver() {
        driver = new Driver();
    }

    public static WebDriver getDriver() {
        return driver.getDriver();
    }

    @After
    public void quitDriver() {
        driver.quitDriver();
    }
}