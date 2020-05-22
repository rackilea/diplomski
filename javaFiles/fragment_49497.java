for (String date : dates) {
    originalList = getEventsWithDate(date);

    if (originalList.size() > 0) {
       mSectionedRecyclerViewAdapter.addSection(new EventSection(date, originalList, getActivity()));
    }
}

private List<Event> getEventsWithDate(String date) {
    List<Event> events = new ArrayList<>();

    for (Event event : mEvents) {
        if (date.equals(event.getDate())) {
            events.add(event);
        }
    }

    return events;
}