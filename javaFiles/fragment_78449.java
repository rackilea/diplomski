String originalHandle = driver.getWindowHandle();

    //Do something to open new tabs

    for(String handle : driver.getWindowHandles()) {
        if (!handle.equals(originalHandle)) {
            driver.switchTo().window(handle);
            driver.close();
        }
    }

    driver.switchTo().window(originalHandle);