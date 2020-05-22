ChromeDriverService chromeDriverService = new ChromeDriverService.Builder()
                            .usingDriverExecutable(new File(ChromeUtils.getChromeDriverPath()))
                            .usingAnyFreePort()
                            .withEnvironment(ImmutableMap.of("DISPLAY",":1024"))
                            .build();

                    try {
                        chromeDriverService.start();
                        webDriver = new ChromeDriver(chromeDriverService, caps);
                    } ....