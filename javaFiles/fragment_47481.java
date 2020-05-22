WebDriverWait wait = new WebDriverWait(driver, 10);

WebElement name = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("name")));
name.sendKeys("Sample Name");

WebElement signup_email = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("email")));
signup_email.sendKeys("abc@xyz.com");