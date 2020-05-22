package com.example.tests;

import com.thoughtworks.selenium.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class selenium extends SeleneseTestCase {

    private static Selenium selenium;

    @Before
    public void setUp() throws Exception {
        selenium = new DefaultSelenium("localhost", 4444, "*firefox", "http://www.google.com/");
        selenium.start();
        selenium.windowMaximize();
    }

    @Test
    public void testSelenium() throws Exception {
        selenium.open("/");
        selenium.waitForPageToLoad("30000");
        Assert.assertEquals("Google", selenium.getTitle());
    }

    @After
    public void tearDown() throws Exception {
        selenium.stop();
    }
}