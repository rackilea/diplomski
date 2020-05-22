public interface EventHandler<T extends Event> {
    void handle (T event);
}

public class PlayerMoveEventHandler implements EventHandler<PlayerMove> {
    @Override
    public void handle (final PlayerMove event) {
        //... handle
    }
}

public class EventRouter {
    private final Map<Class, EventHandler> eventHandlerMap = new HashMap<Class, EventHandler> ();

    public void sendEvent (final Event event) {
        eventHandlerMap.get (event.getClass ()).handle (event);
    }

    public void registerHandler (final Class eventClass, final EventHandler handler) {
        eventHandlerMap.put (eventClass, handler);
    }
}