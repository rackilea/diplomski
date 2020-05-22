package sub.optimal.logger;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SubOptimal
 */
public class Main {

    public static void main(String[] args) throws Exception {
        new Main().loggerDemo();
    }

    private void loggerDemo() throws IOException, SecurityException {
        Logger logger = Logger.getLogger("MyLogger");
        // don't forward any logging to this logger to his parent
        logger.setUseParentHandlers(false);
        // log messages of all level
        logger.setLevel(Level.ALL);

        // define the logfile
        FileHandler fh = new FileHandler("my_log_file.log");
        logger.addHandler(fh);

        // a Formatter with a custom format
        CustomFormatter formatter = new CustomFormatter();
        fh.setFormatter(formatter);

        // few logging examples
        logger.config("message as logger.config");
        logger.fine("message as logger.fine");
        logger.finer("message as logger.finer");
        logger.finest("message as logger.finest");
        logger.info("message as logger.info");
        logger.severe("message as logger.severe");
        logger.warning("message as logger.warning");
    }
}