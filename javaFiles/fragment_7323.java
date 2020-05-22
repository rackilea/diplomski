public static void main(String[] args){

    DOMConfigurator.configure("log4j.xml");
    //if log to file arg = true{
        // Define layout
        PatternLayout layout = new PatternLayout();
        layout.setConversionPattern("%d{ISO8601} %-5p %c{5} - %X{messageId} - %m%n");

        // Create appender
        FileAppender appender = new FileAppender();
        appender.setFile("lss-client.log");
        appender.setLayout(layout);
        appender.activateOptions();

        // Get root logger and add appender.
        log = Logger.getRootLogger();
        log.setLevel(Level.INFO);
        log.addAppender(appender);
    }
}