WebDriver driver = new FirefoxDriver();
    driver.get("http://www.kayak.com/");
    DefaultSelenium sel = new WebDriverBackedSelenium(driver,"http://www.kayak.com/");

    sel.type("//input[@id='destination']", "s");
    sel.fireEvent("//input[@id='destination']", "keydown");