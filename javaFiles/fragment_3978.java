//Using system args instead of Config
    final Logger rootLogger = Logger.getRootLogger();
    Appender ap = null;
    if (args[0].equals("1")) {
        ap = rootLogger.getAppender("TWO");
    } else if ( args[0].equals("2") ) {
        ap = rootLogger.getAppender("ONE");
    }
    if (ap != null) { 
        rootLogger.removeAppender(ap);
    }