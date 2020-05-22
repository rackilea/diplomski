public void checkTextOnPage(String text, boolean expected,String errorMessage, ArrayList<WebDriver> browsers, Logger Logger, String map) throws IOException {
    for(WebDriver driver: browsers){
        try {
            Assert.assertEquals(driver.getPageSource().contains(text), expected, errorMessage);
        }catch (AssertionError e){}
        Capabilities dataBrowser = ((RemoteWebDriver)driver).getCapabilities();
        if(driver.getPageSource().contains(text) == expected){
            Logger.info("[" + this.dateFormat.format(this.date) + "]" +" Browser:" + dataBrowser.getBrowserName() + " -- Version:" + dataBrowser.getVersion() + " -- Text : " + text + " => PRESENT");
        }else if (driver.getPageSource().contains(text) != expected){
            Logger.warning("[" + this.dateFormat.format(this.date) + "]" +" Browser:" + dataBrowser.getBrowserName() + " -- Version:" + dataBrowser.getVersion() + " -- Text : " + text + " => NOT PRESENT");
            File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File(map + "text_" + text + "_NotPresent_" + this.screenshotCount + "_" + dataBrowser.getBrowserName() + ".png"));
            this.screenshotCount++;
            Assert.assertEquals(true, false, e);
        }
    }
}