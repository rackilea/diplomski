package org.openqa.selenium.example;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class selenium extends TestCase {
    public static WebDriver driver;

    @Before
    public void setUp() {
        FirefoxProfile profile = new FirefoxProfile();
        driver = new FirefoxDriver(profile);
    }

    @Test
    public void testSelenium() throws Exception {
        driver.get("http://www.google.com/");
        Assert.assertEquals("Google", driver.getTitle());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}