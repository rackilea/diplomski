WebDriver driver = new RemoteWebDriver(new URL("http://10.0.0.29:4444/wd/hub"), capability);

driver.get(urlPath);

driver.findElement(By.name(username_field)).sendKeys(username);
driver.findElement(By.name(password_field)).sendKeys(password);
driver.findElement(By.className(login_button)).submit();