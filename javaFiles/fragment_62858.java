WebElement username = wait.until(presenceOfElementLocated(By.xpath("\\input[@name='cams_cb_username' and @tabindex='1']")));
WebElement password = driver.findElement(By.xpath("\\input[@name='cams_cb_password' and @tabindex='2']"));
username.clear();
username.sendKeys(username);
password.clear();
password.sendKeys(password);
password.submit();