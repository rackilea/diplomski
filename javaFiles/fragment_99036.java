@Bean(destroyMethod = "quit")
@Scope("singleton")
public WebDriver webDriver() {
    System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
    return new ChromeDriver();
}