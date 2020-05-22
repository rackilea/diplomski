WebDriverWait wait = new WebDriverWait(driver, 30);  

wait.until(ExpectedConditions.elementToBeClickable(By.id("order_billing_name"))).sendKeys("Test Name");  

wait.until(ExpectedConditions.elementToBeClickable(By.id("order_email"))).sendKeys("test123@gmail.com");  

wait.until(ExpectedConditions.elementToBeClickable(By.id("order_tel"))).sendKeys("12345678901");  

wait.until(ExpectedConditions.elementToBeClickable(By.id("bo"))).sendKeys("123 Main Street");  

wait.until(ExpectedConditions.elementToBeClickable(By.id("order_billing_city"))).sendKeys("London");  

wait.until(ExpectedConditions.elementToBeClickable(By.id("order_billing_zip"))).sendKeys("LE1 123");  

wait.until(ExpectedConditions.elementToBeClickable(By.id("cnb"))).sendKeys("1234567890123456");  

wait.until(ExpectedConditions.elementToBeClickable(By.id("vval"))).sendKeys("123");