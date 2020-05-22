public class testclass {

public static void main(String[] args) throws Exception{
    System.setProperty("webdriver.gecko.driver", "C:\\Selenium-java-3.0.1\\geckodriver.exe");
    ProfilesIni profile = new ProfilesIni();
       // this will create an object for the Firefox profile
    FirefoxProfile myprofile = profile.getProfile("default");
       // this will Initialize the Firefox driver
    WebDriver driver = new FirefoxDriver(myprofile);
     driver.get("https://applicationURL/Forms");
     driver.findElement(By.xpath(".//*[@id='login']")).click();
     driver.findElement(By.xpath(".//*[@id='login']")).sendKeys("username");
     driver.findElement(By.xpath(".//*[@id='password']")).click();
     driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("password");
     driver.findElement(By.xpath(".//*[@id='btnlogin']")).click();
     Thread.sleep(7000);
driver.findElement(By.xpath(".//*[@id='panelBarMiddleSearchPanels_i0_txtAttr_1_22']")).click();
     driver.findElement(By.xpath(".//*[@id='panelBarMiddleSearchPanels_i0_txtAttr_1_22']")).sendKeys("LTR*");

}