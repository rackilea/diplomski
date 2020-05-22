Event event = new Event();

event.setSummary("This is my Event");
event.setLocation("127.0.0.1 -- Home sweet Home!!");

ArrayList<EventAttendee> participants = new ArrayList<EventAttendee>();
participants .add(new EventAttendee().setEmail("member@domain.com"));
event.setAttendees(participants);

DateTime start = new DateTime(new Date(), TimeZone.getTimeZone("UTC"));
event.setStart(new EventDateTime().setDateTime(start));

DateTime end = new DateTime(new Date(startDate.getTime() + 3600000), TimeZone.getTimeZone("UTC"));
event.setEnd(new EventDateTime().setDateTime(end));

Event createdEvent = service.events().insert("YourCalendarID", event).execute();