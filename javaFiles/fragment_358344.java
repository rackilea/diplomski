// get parent window ID
String parentHandle = driver.getWindowHandle();

// switch to the new window
for (String handle : driver.getWindowHandles()) {
    if (!handle.equals(parentHandle))
    {
        driver.switchTo().window(handle);
    }
}

//do something with the new window

// switch back to the old window
driver.close();
driver.switchTo().window(parentHandle);