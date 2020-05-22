LoggingPreferences logs = new LoggingPreferences();
logs.enable(LogType.BROWSER, Level.ALL);
logs.enable(LogType.CLIENT, Level.ALL);
logs.enable(LogType.DRIVER, Level.ALL);
logs.enable(LogType.PERFORMANCE, Level.ALL);
logs.enable(LogType.PROFILER, Level.ALL);
logs.enable(LogType.SERVER, Level.ALL);

DesiredCapabilities desiredCapabilities = DesiredCapabilities.firefox();
desiredCapabilities.setCapability(CapabilityType.LOGGING_PREFS, logs);

WebDriver driver = new FirefoxDriver(desiredCapabilities);