public static void relaodLogback() {
        String loggingConfig = System.getProperty("logback.configurationFile");
        if(loggingConfig == null) {
            System.out.println("Logging Config is null");
        }

        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        loggerContext.reset();
        JoranConfigurator configurator = new JoranConfigurator();

        try {
            InputStream configStream = FileUtils.openInputStream(new File(loggingConfig));
            configurator.setContext(loggerContext);
            configurator.doConfigure(configStream); // loads logback file
            configStream.close();
            System.out.println("Loaded configuration file");
        } catch (JoranException | IOException e) {
            e.printStackTrace();
            System.out.println("Failed to log configuration file");
            System.exit(1);
        }
    }