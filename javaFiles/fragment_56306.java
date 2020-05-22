System.setProperty("webdriver.chrome.driver", "E:\\software and tools\\chromedriver_win32\\chromedriver.exe");
WebDriver driver = new ChromeDriver();
driver.get("https://drive.google.com/drive/u/0/");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//goto google drive

driver.findElement(By.xpath("html/body/section/div[2]/div/a")).click();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

// fill emailid
driver.findElement(By.id("identifierId")).sendKeys("xxxxxxxxx");
//click on next
driver.findElement(By.xpath("//span[@class='RveJvd snByac']")).click();
// fill password driver.findElement(By.xpath("//input[@name='password']")).sendKeys("xxxxxxx");
//click on next
driver.findElement(By.xpath("//span[@class='RveJvd snByac']")).click();
driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);


Actions act=new Actions(driver);
//move to download by right clicking and use your file xpath here    
act.contextClick(driver.findElement(By.xpath("//div[contains(text(),'Selenium Study')]"))).sendKeys(Keys.ARROW_DOWN).
sendKeys(Keys.ARROW_DOWN)
.sendKeys(Keys.ARROW_DOWN)
.sendKeys(Keys.ARROW_DOWN)
.sendKeys(Keys.ARROW_DOWN)
.sendKeys(Keys.ARROW_DOWN)
.sendKeys(Keys.ARROW_DOWN)
.sendKeys(Keys.ARROW_DOWN) 
.sendKeys(Keys.ARROW_DOWN)
.sendKeys(Keys.RETURN).build().perform();
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
driver.close();