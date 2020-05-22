private ThreadLocal<WebDriver> drivers = new ThreadLocal<WebDriver>() {
    @Override
    protected WebDriver initialValue() {
        return new FirefoxDriver(); // or whatever
    }

    @Override
    public void remove() {
        WebDriver driver = get();
        if (driver != null) driver.close();
        super.remove();
    }

    @Override
    public void set(WebDriver value) {
        throw new UnsupportedOperationException();
    }
};