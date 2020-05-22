package tjenkinson.events;

import java.util.ArrayList;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import com.google.common.eventbus.EventBus;

/**
 * A guava event bus that holds back any events that are posted to it until the application
 * context has finished loading meaning all eager-loaded beans will have been constructed.
 * 
 * This means any eager-loaded beans that want to listen to events on this event bus will be able
 * to and not miss any events that were posted from other beans before they had a chance to listen.
 */

@Service
public class BufferedEventBus extends EventBus implements ApplicationListener<ContextRefreshedEvent> {

    private boolean applicationContextLoaded = false;
    private final ArrayList<Object> bufferedEvents = new ArrayList<>();

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        synchronized(bufferedEvents) {
            if (applicationContextLoaded) {
                // context already loaded. maybe it's been refreshed.
                return;
            }

            postBufferedEvents();
            applicationContextLoaded = true;
        }
    }

    @Override
    public void post(Object event) {
        synchronized(bufferedEvents) {
            if (applicationContextLoaded) {
                super.post(event);
            }
            else {
                bufferedEvents.add(event);
            }
        }
    }

    private void postBufferedEvents() {
        synchronized(bufferedEvents) {
            for (Object event : bufferedEvents) {
                super.post(event);
            }
            bufferedEvents.clear();
        }
    }

}