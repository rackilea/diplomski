/**
 * Dynamically creates an instance of a Logger.
 * 
 * @param appenderName
 *            most often will be the name of the class this logger will
 *            belong to.
 * @param logFileName
 *            the file name to save the logs to
 * @return
 */
public static org.apache.logging.log4j.Logger createInstanceLogger(String appenderName,
        String logFileName) {
    //call getLogger() which will create and load a logger with a default configuration
    org.apache.logging.log4j.Logger logger = org.apache.logging.log4j.LogManager
            .getLogger(String.format("DynamicLogger%s",
                    String.valueOf(DynamicLogManager.loggerCount++)));
    org.apache.logging.log4j.core.Logger coreLogger = (org.apache.logging.log4j.core.Logger) logger; // cast logger to core logger to access protected methods
    org.apache.logging.log4j.core.LoggerContext context = coreLogger.getContext();
    org.apache.logging.log4j.core.config.BaseConfiguration configuration = (org.apache.logging.log4j.core.config.BaseConfiguration) context
            .getConfiguration();

    TriggeringPolicy compositePolicy = CompositeTriggeringPolicy.createPolicy(
            SizeBasedTriggeringPolicy.createPolicy("5mb"),
            TimeBasedTriggeringPolicy.createPolicy("1", "true"));

    String fileName = String.format("%1$s/%2$s", appenderName, logFileName);
    String filePattern = String.format("%1$s/%2$s.%%d{yyyy-MM-dd}",
            appenderName, logFileName);

    Layout<String> layout = PatternLayout.createLayout(DynamicLogManager._conversionPattern,
            configuration, RegexReplacement.createRegexReplacement("a^", "."), //empty regex replacement
            "utf-8", "false");

    Filter f = ThresholdFilter.createFilter("trace", "accept", "accept");

    Appender a = RollingFileAppender.createAppender(fileName, //fileName
            filePattern, //filePattern
            "true", //append
            appenderName, //appender name
            "true", //bufferred io
            "true", //immediate flush
            compositePolicy, //policy
            null, //strategy default
            layout, //layout
            f, //filter none
            "true", //ignore exceptions
            "false", //advertise
            "null", //advertise uri
            configuration //configuration
            );

    a.start();

    coreLogger.addAppender(a);

    //this is where we would figure out how to configure the logger to listen on a configuration file
    coreLogger.setLevel(Level.ALL); //set the log level of the logger that we are returning to Level.ALL

    return coreLogger; //cast logger back to Logger interface