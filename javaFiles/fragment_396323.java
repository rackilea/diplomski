EventFiringWebDriver driver = new EventFiringWebDriver(new InternetExplorerDriver());
WebDriverEventListener errorListener = new AbstractWebDriverEventListener() {
    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        takeScreenshot("some name");
    }
};
driver.register(errorListener);