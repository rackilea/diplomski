PersonalContact contact = ... ;
Set<Event> events = personalContact.getEventsWithinPeriod(start, end);
// I know all the events are birthdays, but I still have to do this:
for (Event event : events) {
    if (event instanceof Birthday) {
        Birthday birthday = (Birthday) event;
        // Do stuff with birthday
    } // else maybe log some error or something
}