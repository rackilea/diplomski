import org.apache.log4j.Level;
import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggingEvent;

public class MyLog4jFilter extends Filter {

    /**
     * Custom filter to only log INFO events with the 'Instrumentation:' prefix in their message
     */
    @Override
    public int decide(LoggingEvent event) {
        if(event.getLevel() == Level.INFO && event.getMessage().trim().startsWith("Instrumentation:"))
           return ACCEPT;
        else 
           return DENY;
    }

}