// Set up the RollingFileAppender
RollingFileAppender rollingAppender = new RollingFileAppender();
rollingAppender.setFile(logfileURL);

... (set up your appender here)

// Attach it to the root logger
LogManager.getRootLogger().addAppender(rollingAppender);