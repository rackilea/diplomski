Map<String, String> environment = new HashMap<>();
environment.put("DISPLAY", ":1");
GeckoDriverService service = new GeckoDriverService.Builder()
        .usingAnyFreePort()
        .withEnvironment(environment)
        .build();
FirefoxDriver driver = new FirefoxDriver(service);