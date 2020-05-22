public class EventHandler {
    public void handle (final PlayerMove move) {
       //... handle
    }

    public void handle (final Contact contact) {
       //... handle
    }

    public void handle (final Attack attack) {
       //... handle
    }
}

public void sendEvent (final EventHandler handler, final Object event) {
    final Method method = EventHandler.class.getDeclaredMethod ("handle", new Class[] {event.getClass ()});
    method.invoke (handler, event);
}