import java.util.logging.Logger;
import weblogic.logging.LoggerNotAvailableException;
import weblogic.logging.LoggingHelper;
public class GetLogger {
public static Logger getLogger(){   
    Logger logger = null ;
    try {
        logger = LoggingHelper.getDomainLogger() ;
    } catch (LoggerNotAvailableException e) {
        logger = LoggingHelper.getServerLogger() ;
    }
    return logger ;
}
}