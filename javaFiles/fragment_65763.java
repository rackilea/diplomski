import java.util.HashMap;

public class EventManager {

    private HashMap<Class<? extends EventBase>, EventBase> _registeredEvents
            = new HashMap<Class<? extends EventBase>, EventBase>();


    public <T extends EventBase> T Register(T event) {
        @SuppressWarnings("unchecked")
        Class<? extends T> eventType = (Class<? extends T>) event.getClass();

        if (_registeredEvents.containsKey(eventType)) {
            return eventType.cast(_registeredEvents.get(eventType));
        } else {
            _registeredEvents.put(eventType, event);
            return event;
        }
    }
}

class EventBase {}

class ChangeEvent extends EventBase {}

class Main {
    public static void main(String[] args) {
        EventManager em = new EventManager();
        ChangeEvent e = em.Register(new ChangeEvent());
    }
}