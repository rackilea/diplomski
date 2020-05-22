WebDriver driver = new FirefoxDriver();
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
driver.manage().window().maximize();
driver.navigate().to("http://automationpractice.com/index.php");
 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

WebElement women = driver.findElement(By.cssSelector("ul>li:nth-child(1)>a[title='Women']"));

Actions builder = new Actions(driver);  
builder.moveToElement(women).perform();//this will hover to women
Thread.sleep(1000);//avoid using this type of wait. wait using until.

driver.findElement(By.cssSelector("ul>li:nth-child(1)>a[title='T-shirts']")).click();//this will click on t-shirt