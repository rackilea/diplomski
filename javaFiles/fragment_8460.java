public class EventDispatcher {
    private Map<Class<? extends Event>, Collection<Listener<? extends Event>>> listenersDict = new HashMap<Class<? extends Event>, Collection<Listener<? extends Event>>>();

    public void registerListener(Listener<? extends Event> listener) {
        Class<? extends Event> eventType = listener.getEventType();
        Collection<Listener<? extends Event>> listeners = listenersDict.get(eventType);

        if(listeners == null) {
            listeners = new ArrayList<Listener<? extends Event>>();
            listenersDict.put(eventType, listeners);
        }
        listeners.add(listener);
    }

    public void dispatch(Event event) {
        Class<? extends Event> eventType = event.getEventType();
        Collection<Listener<? extends Event>> listeners = listenersDict.get(eventType);

        if(listeners != null) {
            for(Listener<? extends Event> listener : listeners) {
                if (listener.getEventType() == eventType) {
                    listener.onEvent(event);
                }
            }
        }
    }
}