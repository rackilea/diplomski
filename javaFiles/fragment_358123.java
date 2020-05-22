public RemoteWebDriver getWebDriverObject(DesiredCapabilities capabilities) {
        String os = SystemUtils.IS_OS_WINDOWS ? "windows" : "linux";
        System.setProperty("webdriver.gecko.driver", "target/test-classes/selenium_standalone_binaries/" + os + "/marionette/64bit/geckodriver.exe");

        FirefoxOptions options = new FirefoxOptions();
        options.merge(capabilities);
        options.setHeadless(HEADLESS);

        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("network.automatic-ntlm-auth.trusted-uris", "http://localhost:8080");
        profile.setPreference("dom.disable_beforeunload", false);

        options.setProfile(profile);
        options.setLogLevel(FirefoxDriverLogLevel.DEBUG);
        return new FirefoxDriver(options);
    }