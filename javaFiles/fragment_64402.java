void sendEvent (int eventType, Event event, boolean send) {
    if (eventTable == null && !display.filters (eventType)) {
        return;
    }
    if (event == null) event = new Event ();
    event.type = eventType;
    event.display = display;
    event.widget = this;
    if (event.time == 0) {
        event.time = display.getLastEventTime ();
    }
    if (send) {
        sendEvent (event);
    } else {
        display.postEvent (event);
    }
}