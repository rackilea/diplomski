IEDesiredCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
IEDesiredCapabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "http://www.google.com");
IEDesiredCapabilities.internetExplorer().setCapability("ignoreProtectedModeSettings", true);
IEDesiredCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
IEDesiredCapabilities.setJavascriptEnabled(true);
//IEDesiredCapabilities.setCapability("requireWindowFocus", true);
IEDesiredCapabilities.setCapability("enablePersistentHover", false);