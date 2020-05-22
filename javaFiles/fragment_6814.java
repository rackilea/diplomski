public void deleteEvent(Date date){
    Event foundEvent = findEvent(date);

    if (foundEvent == null) {
        return;
    }

    Event[] list = new Event[events.length - 1];
    int j = 0;
    for (int i = 0; i < events.length ; i++) {
        if(!events[i].getDate().equals(foundEvent.getDate())) {
            list[j] = events[I];
            j++;
        }
    }
    events = list;
}