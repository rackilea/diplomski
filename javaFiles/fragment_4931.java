public static class TestJob implements Job {

    private Logger logger;
    private RollingFileAppender appender;

    private void init() {
        logger = Logger.getLogger(TestJob.class);
        appender = new RollingFileAppender();
        appender.setLayout(new PatternLayout("%d %-5p %c{1}:%L - %m%n"));
        appender.setFile("logs/trh1/log1.txt");
        appender.setAppend(false);
        appender.setMaxFileSize("100MB");
        appender.setMaxBackupIndex(10);
        appender.activateOptions();
        logger.setAdditivity(false);
        logger.addAppender(appender);
    }

    private void destroy() {
        logger.removeAppender(appender);
    }

    public void execute(JobExecutionContext context) throws JobExecutionException {
        init();

        for (int i = 0; i < 10; i++) {
            if (logger.isInfoEnabled()) {
                logger.info("This is " + i);
            }
        }

        destroy();
    }

}