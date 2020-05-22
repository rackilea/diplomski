import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.RollingFileAppender;
import org.apache.log4j.spi.LoggingEvent;

public class MyRollingFileAppender extends RollingFileAppender {

    private List<LoggingEvent> events = new ArrayList<>();

    @Override
    public synchronized void doAppend(LoggingEvent event) {
        events.add(event);
        super.doAppend(event);
    }

    public synchronized List<LoggingEvent> getEvents() {
        List<LoggingEvent> clone = new ArrayList<>(events);
        events.clear();
        return clone;
    }

}