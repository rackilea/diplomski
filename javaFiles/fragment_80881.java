import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;

public class SimpleLoggerTest {

    private void logMessages(Logger logger) {
        logger.warning(getLoggerName(logger) + ": warning message");
        logger.info(getLoggerName(logger) + ": info message");
        logger.fine(getLoggerName(logger) + ": fine message");
    }


    private String getLoggerName(Logger logger) {
        String loggerName = logger.getName();
        if (loggerName.isEmpty()) {
            return "[root logger]";
        }
        return loggerName;
    }

    private void listHandlerLevels(Logger logger) {
        for (Handler handler : logger.getHandlers()) {
            logger.info(getLoggerName(logger) + ": handler level = " + handler.getLevel());
        }
        Logger parentLogger = logger.getParent();
        if (null != parentLogger) {
            for (Handler handler : parentLogger.getHandlers()) {
                logger.info("parent logger handler (" + getLoggerName(parentLogger) + "): handler level = " + handler.getLevel());
            }
        }
    }

    private void setHandlerLevels(Logger logger, Level level) {
        for (Handler handler : logger.getHandlers()) {
            handler.setLevel(level);
        }
        Logger parentLogger = logger.getParent();
        if (null != parentLogger) {
            for (Handler handler : parentLogger.getHandlers()) {
                handler.setLevel(level);
            }
        }
    }
    @Test
    public void testLoggingLevel() {
        Logger myLogger = Logger.getLogger(SimpleLoggerTest.class.getName());
        Logger rootLogger = myLogger.getParent();

        // list the default handler levels
        listHandlerLevels(myLogger);
        listHandlerLevels(rootLogger);

        // log some messages
        logMessages(myLogger);
        logMessages(rootLogger);

        // change the logger levels
        myLogger.setLevel(Level.ALL);
        rootLogger.setLevel(Level.WARNING);

        // list the handler levels again
        listHandlerLevels(myLogger);
        listHandlerLevels(rootLogger);

        // log some messages (again)
        logMessages(myLogger);
        logMessages(rootLogger);

        // change Handler levels to FINE
        setHandlerLevels(myLogger, Level.FINE);

        // list the handler levels (last time)
        listHandlerLevels(myLogger);
        listHandlerLevels(rootLogger);

        // log some messages (last time)
        logMessages(myLogger);
        logMessages(rootLogger);
    }
}