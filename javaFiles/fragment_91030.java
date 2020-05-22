public class Loginchrome {
WebDriver driver1;

@Test//This is TestNG annotation 
public void testLoginPageTitle() {
    System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
    driver1 = new ChromeDriver ();

    driver1.get("http://test01.boston-idm.ci.opal.synacor.com:4080/flowcontrol/1/");
    driver1.findElement(By.linkText("Cableco Login")).click();

    driver1.findElement(By.id("E-mail Address")).sendKeys("1mehul@cableco.com");
    driver1.findElement(By.id("Password")).sendKeys("password1");
    driver1.findElement(By.id("Login")).click();
}

@AfterMethod
public void kill()
{
   driver1.quit();
}
}