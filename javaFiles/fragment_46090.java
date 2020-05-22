package com.testerstories.learning.symbiote;

import com.testerstories.learning.helpers.DriverFactory;
import com.testerstories.learning.helpers.Selenium;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class LoginIT extends DriverFactory {
    WebDriver driver;
    Selenium selenium;

    @Test
    public void loginAsAdmin() {
        driver = DriverFactory.getDriver();
        selenium = new Selenium(driver);

        driver.get("http://localhost:9292");

        selenium.withElement("open").click();

        selenium.waitForPresence("username");

        selenium.withElement("username").sendKeys("admin");
        selenium.withElement("password").sendKeys("admin");
        selenium.withElement("login-button").submit();

        selenium.waitForPresence("notice", "className");

        assertThat(selenium.withElement("notice", "className").getText(), equalTo("You are now logged in as admin."));
    }
}