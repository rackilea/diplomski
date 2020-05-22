@Test
public void logMessage() {
    // set up new logger with output directed to standard out
    Logger logger = Logger.getLogger("my.test.logger");
    StreamHandler sh = new StreamHandler(System.out, new SimpleFormatter());
    logger.addHandler(sh);

    // log a warning message
    logger.warning("logger message"); // message 1

    // turn off parent handlers
    logger.setUseParentHandlers(false);

    // log a second warning message
    logger.warning("second logger message"); // message 2

    // print somehting to standard output
    System.out.println("standard output message");  //message 3

    // FLUSH THE STREAM HANDLER !!!
    sh.flush();
}