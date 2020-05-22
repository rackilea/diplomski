public boolean isElementNotPresent(By by) {
    boolean flag = true;
    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    if (!driver.findElements(by).size() > 0) {
        flag = false;
    } 
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    return flag;
}