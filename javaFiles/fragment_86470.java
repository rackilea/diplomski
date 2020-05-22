package com.eureqa.scripts;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Phase1 {
    public static WebDriver driver;
    public static WebDriver driver1;

    public void navigation1(WebDriver driver1) 
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        assertTrue("commonheader:headerForm:projectlist not found", 
                     driver1.findElements(By.id("commonheader:headerForm:projectlist")).size() == 1);
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Reports"))).click();
    }

    public static void main(String arr[]) throws InterruptedException
    {
        WebDriver driver1=LoginObject.driver();
        System.out.println("Object Received");

        LoginEureqa m=new LoginEureqa();
        m.login(driver1);

        Phase1 p1=new Phase1();
        p1.navigation1(driver1);
        System.out.println();

        System.out.println("Phase1 executed successf`enter code here`ully");

    }
}