List<Event> allEvents = // fill with your events.
List<Event> noRepeat = new ArrayList<Event>();

for (Event event : allEvents) {
    boolean isFound = false;
    // check if the event name exists in noRepeat
    for (Event e : noRepeat) {
        if (e.getName().equals(event.getName()) || (e.equals(event))) {
            isFound = true;        
            break;
        }
    }
    if (!isFound) noRepeat.add(event);
}