public class MyLogger {

    static MyFormatter formatter = null;
    static FileHandler fileHandler = null;
    static ConsoleHandler consoleHandler = null;
    static String preName = "";
    static Long time = System.currentTimeMillis();
    static String file_path = "/Users/rs/Documents/asl_v1/" + preName + time + ".log";

    // setup method
    static public void setup() throws SecurityException, IOException {
        /*if (fileHandler == null)*/
            fileHandler = new FileHandler(file_path, true);
        if (consoleHandler == null)
            consoleHandler = new ConsoleHandler();
        if (formatter == null)
            formatter = new MyFormatter();
    }

    static public Logger classLogger(String className) {
        Logger logger = Logger.getLogger(className);
        logger.setUseParentHandlers(false);
        /*if (fileHandler == null || consoleHandler == null || formatter == null)*/    
            try {
                setup();
                fileHandler.setFormatter(formatter);

                consoleHandler.setFormatter(formatter);
                Handler[] handlers = logger.getHandlers();

                // array of registered handlers
                for (Handler handler : handlers) {
                   logger.removeHandler(handler);
                }

                logger.setLevel(Level.INFO);
                logger.addHandler(fileHandler);
            } catch (SecurityException | IOException e) {
                e.printStackTrace();
            }

        return logger;
    }

    static public Logger classLogger(String className, String log_prefix) {
        preName = log_prefix;
        file_path = "/Users/rs/Documents/asl_v1/" + preName + time + ".log";
        return classLogger(className);
    }
}