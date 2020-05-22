String currentTab = driver.getWindowHandle();
for (String tab : driver.getWindowHandles()) {
    if (!tab.equals(currentTab)) {
        driver.switchTo().window(tab); 
    }       
}
// do something on new tab