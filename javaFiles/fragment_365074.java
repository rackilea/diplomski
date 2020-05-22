package Utility;

   import org.openqa.selenium.By;
   import org.openqa.selenium.WebDriver;


   public class Login_Page {

   //public static WebDriver driver;


   public static void login()
   {

   Base.openURL();

   //note the change from driver  to Base.driver
   Base.driver.manage().window().maximize();
   Base.driver.findElement(By.id(Constant_value_utility.loginbox)).sendKeys(Constant_value_utility.username);
   Base.driver.findElement(By.id(Constant_value_utility.passbox)).sendKeys(Constant_value_utility.password);
   Base.driver.findElement(By.id(Constant_value_utility.loginbt)).click();