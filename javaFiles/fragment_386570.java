private void putEventIntoMap(HashMap<Date, List<Event>> map, Event event) {
    if (map.containsKey(event.when)) {
        map.get(event.when).add(event);
    } else {
        List<Event> list = new ArrayList<>();
        list.add(event);
        map.put(event.when, list);
    }
}