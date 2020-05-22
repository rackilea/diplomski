// We already know this is ok, because FirefoxDriver implements (IS-A) TakesScreenshot.
WebDriver driver = new FirefoxDriver();
TakesScreenshot screenshottingDriver = (TakesScreenshot)driver;

// This will fail at run-time, because HtmlUnitDriver does not implement TakesScreenshot;
WebDriver driver = new HtmlUnitDriver();
TakesScreenshot screenshottingDriver = (TakesScreenshot)driver;

// You can use the `instanceof` operator to check:
if (driver instanceof TakesScreenshot) {
    // we can be sure we can take screenshots, the cast will be safe
    ((TakesScreenshot)driver).getScreenshotAs(...);
}