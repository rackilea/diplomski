package com.example.tests;

import com.thoughtworks.selenium.*;

public class selenium extends SeleneseTestCase {

    private static Selenium selenium;

    public void setUp() throws Exception {
        selenium = new DefaultSelenium("localhost", 4444, "*firefox", "http://www.google.com/");
        selenium.start();
        selenium.windowMaximize();
    }

    public void testSelenium() throws Exception {
        selenium.open("/");
        selenium.waitForPageToLoad("30000");
        Assert.assertEquals("Google", selenium.getTitle());
    }

    public void tearDown() throws Exception {
        selenium.close();
    }
}