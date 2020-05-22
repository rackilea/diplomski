String calendarLocation;
// set calendar URI (depends on api level)
if (Build.VERSION.SDK_INT >= 8) {
    calendarLocation = "content://com.android.calendar/"; 
} else {
    calendarLocation = "content://calendar/";
}

// URIs for events and attendees tables
Uri EVENTS_URI = Uri.parse(calendarLocation + "events");
Uri ATTENDEES_URI = Uri.parse(calendarLocation + "attendees");

ContentResolver cr = getContentResolver();

// add event
ContentValues values = new ContentValues();
values.put("dtstart", startMillis);
values.put("dtend", endMillis);
values.put("title", "Jazzercise");
values.put("description", "Group workout");
values.put("calendar_id", calID);
values.put("eventTimezone", "America/Los_Angeles");
Uri uri = cr.insert(EVENTS_URI, values);

// get the event ID that is the last element in the Uri
long eventID = Long.parseLong(uri.getLastPathSegment());

// add attendee
values = new ContentValues();
values.put("attendeeName", "Trevor");
values.put("attendeeEmail", "trevor@example.com");
values.put("attendeeRelationship", 1);
values.put("attendeeType", 2);
values.put("attendeeStatus", 3);
values.put("event_id", eventID);
cr.insert(ATTENDEES_URI, values);