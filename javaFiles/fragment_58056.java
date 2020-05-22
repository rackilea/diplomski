package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class login {

    @FindBy (id="p")
    public WebElement password;

    @FindBy (id="u")
    public WebElement user;

    public void Login(WebDriver driver, String login,String pass) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("p")));
        password.clear();
        password.sendKeys(pass);
        user.clear();
        user.sendKeys(login);
        driver.findElement(By.id("submit_button")).click();
        }}