jerseyConfig.register(
        new LoggingFeature(          
          java.util.logging.Logger.getLogger(LoggingFeature.DEFAULT_LOGGER_NAME),
          java.util.logging.Level.SEVERE, 
          LoggingFeature.Verbosity.PAYLOAD_ANY, 
          Integer.MAX_VALUE)
       );