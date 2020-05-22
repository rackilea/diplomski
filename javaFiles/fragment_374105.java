interface EventHandler
{
    Set<Event> eventTypes();
    void onEvent(Event event);
}

interface Event
{
    // used as a marker interface, but probably add some methods
}

enum MouseEvent implements Event
{
    ON_CLICK
    //... and whatever else
}

class OnClickEventHandler implements EventHandler
{
    public Set<Event> eventTypes()
    {
        Set<Event> events = new HashSet<>();
        events.add(MouseEvent.ON_CLICK);
        return events;
    }

    public void onEvent(Event event)
    {
        if (event == MouseEvent.ON_CLICK)
        {
            System.out.println("Mouse clicked");
        }
    }
}

class EventManager
{
    private final Map<Event, List<EventHandler>> handlers = new HashMap<>();

    public void registerListener(EventHandler handler)
    {
        for (Event eventType : handler.eventTypes())
        {
            handlers.putIfAbsent(eventType, new ArrayList<>());
            handlers.get(eventType).add(handler);
        }
    }

    public void dispatchEvent(Event event)
    {
        handlers.getOrDefault(event, Collections.emptyList())
            .forEach(handler -> handler.onEvent(event));
    }
}