// Store the current window handle
String winHandleBefore = driver.getWindowHandle();

// Perform the click operation that opens new window

// Switch to new window opened
for(String winHandle : driver.getWindowHandles()){
    driver.switchTo().window(winHandle);
}

// Perform the actions on new window

// Close the new window, if that window no more required
driver.close();

// Switch back to original browser (first window)
driver.switchTo().window(winHandleBefore);

// Continue with original browser (first window)