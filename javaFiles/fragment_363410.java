@Test(dataProvider = "ABN")

public void Snap_Login(int UserID) throws InterruptedException{
System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
WebDriver Snap = new ChromeDriver();
Snap.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
Snap.get("https://www.snapdeal.com/");
Thread.sleep(3000);
Snap.manage().window().maximize();
Thread.sleep(2000);
Snap.findElement(By.xpath(".//*[@id='sdHeader']/div[4]/div[2]/div/div[3]/div[3]/div/span[1]")).click();
Snap.findElement(By.xpath("//a [@href='https://www.snapdeal.com/login']")).click();
Snap.switchTo().frame("loginIframe");
Snap.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
Thread.sleep(1000);
Snap.findElement(By.id("userName")).sendKeys(UserID+""); // PROBLEM
Snap.findElement(By.id("checkUser")).click();
Snap.quit();
}

@DataProvider(name = "ABN")
public Object [][] Snap_Data(){
return new Object[][] {{777777},{888888},{984149104}};   
}