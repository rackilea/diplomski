package com.stack.JarCreation;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class RunnableJar {
    public int a = 1;

    @Test
    public void testRegister() {
        WebDriver driver=null;
        try {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.get("http://newtours.demoaut.com/");
            driver.findElement(By.linkText("REGISTER")).click();
            driver.findElement(By.name("firstName")).sendKeys("User1");
            driver.findElement(By.name("lastName")).sendKeys("Surname1");
            driver.findElement(By.name("phone")).sendKeys("123456789");
            driver.findElement(By.name("userName")).sendKeys("user1@test.com");
            driver.findElement(By.name("address1")).sendKeys("Test Address");
            driver.findElement(By.name("city")).sendKeys("Test City");
            Select select = new Select(driver.findElement(By.name("country")));
            select.selectByVisibleText("ANGOLA");
            driver.findElement(By.name("email")).sendKeys("user1@test.com");
            driver.findElement(By.name("password")).sendKeys("user1");
            driver.findElement(By.name("confirmPassword")).sendKeys("user1");
            driver.findElement(By.name("register")).click();

            if (a == 1)
                System.out.println("OK");
            else
                System.out.println("NOT OK");
            driver.quit();
        }

        catch (Exception e) {
            System.out.println(e.getMessage());
            driver.quit();
        }
    }
}