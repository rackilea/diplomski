import org.slf4j.LoggerFactory;
import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;

Logger root = (Logger)LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
root.setLevel(Level.INFO);