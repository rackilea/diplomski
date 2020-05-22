public class LogConfig {

public static RollingFileAppender init(Logger LOGGER) {

    String logInfo = LOGGER.getClass().toString();

    String loglevel = getLogLevel(logInfo);
    String logClazz = getLogClazz(logInfo);
    String logModule = getModule(logInfo);

    PatternLayout PL = new PatternLayout("%d [%-5p] %m (%c)[%t]%n");

    try {
        if (logModule == "presentation") {
        RollingFileAppender appender = new RollingFileAppender(PL, "PathToLogFile_1.log", true);
        return appender;
    } 
    else if (logModule == "business") {
        RollingFileAppender appender = new RollingFileAppender(PL, "PathToLogFile_2.log", true);
        return appender;
    }

    RollingFileAppender appender = new RollingFileAppender(PL, "PathToLogFile_3.log", true);
    return appender;

    }catch (IOException e) {
        e.printStackTrace();
    }
    return null;
    }

private static String getLogClazz(String logInfo) {
    return logInfo.substring(logInfo.indexOf("("), logInfo.indexOf(")") + 1);
}

private static String getLogLevel(String logInfo) {
    return logInfo.substring(24, 31);
}

private static String getModule(String logInfo) {
    logInfo = logInfo.substring(logInfo.indexOf("(") + 15, logInfo.length());
    return logInfo.substring(0, logInfo.indexOf("."));
    }
}