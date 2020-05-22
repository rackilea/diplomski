public WebDriver initialize() throws InterruptedException, IOException {
    System.out.println("Launching browser");
    System.setProperty("webdriver.chrome.driver",
            "C:\\Users\\admin\\eclipse-workspace\\SampleProject\\src\\main\\java\\selenium\\org\\sample\\SampleProject\\data\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    driver.navigate().to("http://automationpractice.com/index.php?controller=authentication&back=my-account");
    Thread.sleep(6000);

return driver;
}