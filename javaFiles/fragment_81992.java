public void bCanGo() { 

WebDriver driver; 

driver = new FirefoxDriver(); 
System.out.println("New Private Window"); 

//Puts an Implicit wait, Will wait for 25 seconds before throwing exception 
driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS); 


//Launch site 
driver.navigate().to("my url"); 
System.out.println("Map Page Launched"); 


//Maximize the browser 
driver.manage().window().maximize(); 
System.out.println("Browser Maximized"); 

//Login 
driver.findElement(By.xpath(".//*[@id='login_btn']")).click(); 
driver.findElement(By.xpath(".//*[@id='loginform']/div[5]/input")).sendKeys("manuli@et.lk"); 
driver.findElement(By.xpath(".//*[@id='loginform']/div[6]/input")).sendKeys("1qaz2wsx"); 
driver.findElement(By.xpath(".//*[@id='btn-login']")).click(); 


// Click on a Hotel 
driver.findElement(By.xpath(".//*[@id='image_row']/div/div[1]/div/span/a/img")).click(); 

if ((driver.getCurrentUrl())!= ("correct url")){ 
System.out.println("Successfully redirect to the Aliya hotel Page"); 
} 
else{ 
System.out.println("Failed to redirect to the Aliya hotel Page"); 
} 


// Click Book Now Button 
driver.findElement(By.cssSelector(".btn.btn-primary.btn-lg.book-btn")).click(); 
System.out.println("Successfully redirect to the cart page(With Aliya)"); 


if ((driver.getCurrentUrl())!= ("correct url")){ 

driver.navigate().to("correct url"); 

// Click Proceed to checkout 
driver.findElement(By.cssSelector(".btn.btn-success.pro-btn")).click(); 

System.out.println("Clicked Proceed to checkout"); 

} 


// Open a new Private Window 
FirefoxProfile firefoxProfile = new FirefoxProfile(); 
firefoxProfile.setPreference("browser.private.browsing.autostart",true); 

driver = new FirefoxDriver(); 
driver.get("url"); 

System.out.println("New Private Window"); 

}