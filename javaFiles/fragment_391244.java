String tabHandle = driver.getWindowHandle();

driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");

// switch to the new window
for (String handle : driver.getWindowHandles()) {
    if (!handle.equals(tabHandle))
    {
        driver.switchTo().window(handle);
    }
}

driver.get("http://www.gmail.com");

// close the new tab and switch back to the old one
driver.close();
driver.switchTo().window(tabHandle);