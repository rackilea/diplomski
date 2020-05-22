URL feedUrl = new URL("http://www.google.com/calendar/feeds/default/private/full");

CalendarQuery myQuery = new CalendarQuery(feedUrl);
myQuery.setMinimumStartTime(DateTime.parseDateTime("2006-03-16T00:00:00"));
myQuery.setMaximumStartTime(DateTime.parseDateTime("2006-03-24T23:59:59"));

CalendarService myService = new CalendarService("exampleCo-exampleApp-1");
myService.setUserCredentials("jo@gmail.com", "mypassword");

// Send the request and receive the response:
CalendarEventFeed resultFeed = myService.query(myQuery, Feed.class);