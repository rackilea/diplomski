System.setProperty("webdriver.gecko.driver", "C:\\your_directory\\geckodriver.exe");

WebDriver driver = new FirefoxDriver();
driver.get("https://www.flipkart.com/");

driver.findElement(By.xpath("//div[@class='AsXM8z']/ul/li/a[@class='_2k0gmP'][text()='Log In']")).click();

//Email
WebElement elem = driver.findElement(By.xpath("//input[@class='_2zrpKA']"));
elem.sendKeys("emailid@domain.com");

//Password
WebElement elem2 = driver.findElement(By.xpath("//input[@class='_2zrpKA _3v41xv']"));
elem2.sendKeys("pass_word");

//Login Button
driver.findElement(By.xpath("//button[@class='_2AkmmA _1LctnI _7UHT_c']")).click();

System.out.println("Success");

//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
Thread.sleep(5000);

//Click on Name
WebElement elem3 = driver.findElement(By.xpath("//div[@class='AsXM8z']/ul/li/a[@class='_1AHrFc _2k0gmP']"));
System.out.println("success");
Actions action = new Actions(driver);
action.moveToElement(elem3).build().perform();
driver.findElement(By.xpath("//div[@class='_1H5F__']/div/ul/li/ul/li/a[@class='_2k0gmP'][text()='Log Out']")).click();