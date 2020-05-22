private static ChromeDriverService service;
private WebDriver driver;
//code block
service = new ChromeDriverService.Builder()
 .usingDriverExecutable(new File("path/to/my/chromedriver.exe"))
 .usingAnyFreePort()
 .build();
chromeDriverService.start();

ChromeOptions option = new ChromeOptions();
option.addArguments("--incognito");
driver = new RemoteWebDriver(service.getUrl(), options);