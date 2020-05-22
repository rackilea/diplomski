DesiredCapabilities capabilities = DesiredCapabilities.chrome();

Map<String, String> mobileEmulation = new HashMap<String, String>();
mobileEmulation.put("deviceName", "Apple iPhone 6");
Map<String, Object> mobileOptions = new HashMap<String, Object>();
mobileOptions.put("mobileEmulation", mobileEmulation);

mobileOptions.put("args", Arrays.asList("disable-extensions",
"test-type", "no-default-browser-check", "ignore-certificate-errors"));

capabilities.setCapability(ChromeOptions.CAPABILITY, mobileOptions);
driver = new RemoteWebDriver(service.getUrl(), capabilities);