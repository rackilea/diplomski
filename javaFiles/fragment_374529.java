public class LogMe {        
    private static LogMe logMe;
    private static Logger logger;    
    private static FileHandler fh;
    private static Formatter sf;

    public LogMe() {
    //Make this class a singleton
        if (logMe != null) {
           return;
       }

        //Create the log file            
        try {
        fh = new FileHandler("../xyz/LogFile.log");
    } catch (Exception e) {
        e.printStackTrace();
    }

    sf = new SimpleFormatter();
    fh.setFormatter(sf);            
    logger.addHandler(fh);

    //Part of making this class a singleton
    logger = Logger.getLogger("LogMe");
    logMe = this;        
}

public Logger getLogger() {
    return LogMe.logger;
}
}