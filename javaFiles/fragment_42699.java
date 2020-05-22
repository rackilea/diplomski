// Entering the credentials in the login window.
driver.findElement(By.id(txtUserId)).clear();
driver.findElement(By.id(txtUserId)).sendKeys(poovan);
driver.findElement(By.id(txtPassword)).clear();
driver.findElement(By.id(txtPassword)).sendKeys(welcome1);
driver.findElement(By.id(btnSubmit)).click();
// Here the login window gets closed, handler to that window disappears, and driver becomes stale.
// So we need update the driver to point to the new window
handleMultipleWindows("The title of my new window");
driver.findElement(By.name(bono)).sendKeys(080);