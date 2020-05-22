// Removed wildcard
private HashMap<String, List<EventListener<Event>>> events = new HashMap<>();

public synchronized <T extends Event> void fireEvent(T event){
  String key = event.getClass().getName();
  if(events.containsKey(key)){
     // Removed wildcard.
     Iterator<EventListener<Event>> i = events.get(key).iterator();
     while(i.hasNext()){
        i.next().receiveEvent(event); // This compiles now.
     }
  }
}