public class EventBus implements EventHandler 
{
    private final static EventBus INSTANCE = new EventBus();
    private HashMap<Module, ArrayList<Subscriber>> subscribers;

    private EventBus()  
    { 
      subscribers = new HashMap<Module, ArrayList<Subscriber>>(); 
    }

    public static EventBus get() { return INSTANCE; }

    public void fire(ScEvent event)
    {
        if (subscribers.containsKey(event.getKey()))
            for (Subscriber s : subscribers.get(event.getKey()))
                s.rescue(event);
    }

    public void subscribe(Subscriber subscriber, Module[] keys)
    {
        for (Module m : keys)
            subscribe(subscriber, m);
    }

    public void subscribe(Subscriber subscriber, Module key)
    {
        if (subscribers.containsKey(key))
            subscribers.get(key).add(subscriber);
        else
        {
            ArrayList<Subscriber> subs = new ArrayList<Subscriber>();
            subs.add(subscriber);
            subscribers.put(key, subs);
        }
    }

    public void unsubscribe(Subscriber subscriber, Module key)
    {
        if (subscribers.containsKey(key))
            subscribers.get(key).remove(subscriber);
    }

}