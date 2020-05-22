import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.Level;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.maven.plugin.logging.Log;
public class MavenLoggerLog4jBridge extends AppenderSkeleton {
    private Log logger;

    public MavenLoggerLog4jBridge(Log logger) {
        this.logger = logger;
    }

    protected void append(LoggingEvent event) {
        int level = event.getLevel().toInt();
        String msg = event.getMessage().toString();
        if (level <= Level.DEBUG_INT ) {
            this.logger.debug(msg);
        } else if (level == Level.INFO_INT) {
            this.logger.info(msg);
        } else if (level == Level.WARN_INT) {
            this.logger.warn(msg);
        } else if (level == Level.ERROR_INT || level == Level.FATAL_INT) {
            this.logger.error(msg);
        }
    }

    public void close() {
    }

    public boolean requiresLayout() {
        return false;
    }
}