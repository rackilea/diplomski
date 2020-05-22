public static void closeTheWindowWithTitle(String title)
{
    Set<String> tabs = driver.getWindowHandles();
    String mainWindow = driver.getWindowHandle();

    for(int i = 0; i < tabs.size(); i++)
    {
        // you need to switch to the window before checking title
        driver.switchTo().window(tabs.get(i));
        log.debug("switched to " + driver.getTitle() + " Window");
        if(driver.getTitle().contains(title))
        {
            driver.close();
            log.debug("Closed the  " + driver.getTitle() + " Window");
            break; // this breaks out of the loop, which I'm assuming is what you want when a match is found
        }
    }
    driver.switchTo().window(mainWindow);
}