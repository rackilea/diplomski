public class RollOverLog4j {

    public static void rollover() {
        public final Logger logger = LogManager.getLogger("test");

        Map<String, Appender> appenders = ((org.apache.logging.log4j.core.Logger) logger).getAppenders();
        Iterator<Entry<String, Appender>> appenderIterator = appenders.entrySet().iterator();
        while (appenderIterator.hasNext()) {
            Appender appender = appenderIterator.next().getValue();
            if (appender instanceof RollingRandomAccessFileAppender) {
                ((RollingRandomAccessFileAppender) appender).getManager().rollover();
            }
        }
    }

}