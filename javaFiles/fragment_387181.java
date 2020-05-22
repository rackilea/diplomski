//Enable performance logging
    LoggingPreferences logPrefs = new LoggingPreferences();
    logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
    capa.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);

    //Start driver
    WebDriver driver = new ChromeDriver(capa);