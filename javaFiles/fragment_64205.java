String URL = "http://way2automation.com/way2auto_jquery/tooltip.php";
WebDriver driver = new ChromeDriver();
driver.get(URL);
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
driver.manage().window().maximize();
Thread.sleep(5000);

WebElement sign=driver.findElement(By.xpath("//p[@class='text_popup']/a[contains(text(),'Signin')]"));
sign.click();
Thread.sleep(5000);
driver.findElement(By.xpath("//div[@id='login']/form/fieldset[1]/input")).sendKeys("myusername");
Thread.sleep(5000);
driver.findElement(By.xpath("//div[@id='login']/form/fieldset[2]/input")).sendKeys("password");
driver.findElement(By.xpath("//div[@id='login']/form/div/div[2]/input")).click();