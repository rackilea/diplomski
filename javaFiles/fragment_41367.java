BrowserMobProxy proxy = new BrowserMobProxyServer();
proxy.start(0);
HashSet<CaptureType> enable = new HashSet<CaptureType>();
enable.add(CaptureType.REQUEST_HEADERS);
enable.add(CaptureType.REQUEST_CONTENT);
enable.add(CaptureType.RESPONSE_HEADERS);
proxy.enableHarCaptureTypes(enable);
HashSet<CaptureType> disable = new HashSet<CaptureType>();
disable.add(CaptureType.REQUEST_COOKIES);
disable.add(CaptureType.RESPONSE_COOKIES);
proxy.disableHarCaptureTypes(disable);

//get the Selenium proxy object
Proxy selProxy = ClientUtil.createSeleniumProxy(proxy);

capabilities = new DesiredCapabilities();
capabilities.setCapability(CapabilityType.PROXY, selProxy);
capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);

FirefoxProfile profile = new FirefoxProfile();
WebDriver driver = new FirefoxDriver(new FirefoxBinary(),profile,capabilities);


driver.get(url);

Har har = proxy.getHar();