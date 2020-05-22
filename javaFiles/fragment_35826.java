private static ChromeDriverService service;
private WebDriver driver;
//code block
service = new ChromeDriverService.Builder()
 .usingDriverExecutable(new File("path/to/my/chromedriver.exe"))
 .usingAnyFreePort()
 .build();
chromeDriverService.start();        
DesiredCapabilities capabilities = new DesiredCapabilities();
capabilities.setCapability("...", true);
ChromeOptions option = new ChromeOptions();
option.addArguments("--incognito");
option.merge(capabilities);
driver = new RemoteWebDriver(service.getUrl(), options);