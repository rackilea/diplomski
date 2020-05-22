public class SocketNotMain {

    @Test
    public void testSomething() {
        System.setProperty("webdriver.chrome.driver", "C:\\automation\\drivers\\chromedriver.exe"); 
        WebDriver driver = new ChromeDriver(); 

        driver.get("https://www.investing.com"); 
        driver.navigate().refresh();
        driver.findElement(By.cssSelector("[href = '/markets/']")).click();
    } 


}