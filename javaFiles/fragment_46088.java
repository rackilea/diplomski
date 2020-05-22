package com.testerstories.learning.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
    private WebDriver driver;

    public WebDriver getDriver() {
        if (null == driver) {
           driver = new FirefoxDriver();
        }
        return driver;
    }

    public void quitDriver() {
        if (null != driver) {
            driver.quit();
            driver = null;
        }
    }
}