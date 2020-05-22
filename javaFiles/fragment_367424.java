class Task implements Runnable {

    private final String path;
    private final String name;

    public Task(String path, String name) {
        this.path = path;
        this.name = name;
    }

    public void run() {
        // Create file appender
        FileAppender appender = new FileAppender();
        appender.setFile(path);
        appender.setLayout(new PatternLayout("%d [%t] %-5p %c - %m%n"));
        appender.activateOptions();

        // Get logger and add appender
        Logger logger = Logger.getLogger(name);
        logger.setAdditivity(false);
        logger.addAppender(appender);

        // Task
        logger.info("Hello World!");

        // Remove appender
        logger.removeAppender(appender);
    }

}

public static void main(String[] args) {
    new Thread(new Task("logs/A.log", "com.company.A")).start();
    new Thread(new Task("logs/B.log", "com.company.B")).start();
}