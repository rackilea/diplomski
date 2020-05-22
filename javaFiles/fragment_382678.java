@Test(dataProvider="testdata")
public void simpleTest(String url) {

    System.setProperty("webdriver.chrome.driver",
            System.getProperty("user.dir") + File.separator + "drivers\\chromedriver.exe");

    WebDriver driver = new ChromeDriver();
    driver.get(url);
}

@DataProvider(name="testdata", parallel=true)
public Object[][] data(){
    return new Object[][] {
        {"http://www.google.com"},
        {"http://www.seleniumhq.org"}
    };