import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext; 
import org.apache.logging.log4j.message.MessageFactory;

public class MyLogger extends org.apache.logging.log4j.core.Logger
{
    MyLogger(LoggerContext context, String name, MessageFactory messageFactory) {
        super(context, name, messageFactory);
    }

    public static Logger getLogger(String name) {
        Logger logger_ = LogManager.getLogger(name);
        return logger_;
    }
}