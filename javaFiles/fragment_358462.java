@Before
public void openBrowser() throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "chromedriver");
    driver = new ChromeDriver();
    driver.get("http://localhost:8000");
    Thread.sleep(1000);
}