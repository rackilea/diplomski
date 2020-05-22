String mainWindow = driver.getWindowHandle();

//here, your action to bring up a new window
driver.click    

for (String winHandle : driver.getWindowHandles()) {
        driver.switchTo().window(winHandle);
        if(!winHandle.equals(mainWindow)) {
            driver.close();
        }
}

//switch to main window
driver.switchTo().window(mainWindow);