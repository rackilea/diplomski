ContentResolver cr = ctx.getContentResolver();
ContentValues values = new ContentValues();

values.put(CalendarContract.Events.DTSTART, dtstart);
values.put(CalendarContract.Events.TITLE, title);
values.put(CalendarContract.Events.DESCRIPTION, comment);

TimeZone timeZone = TimeZone.getDefault();
values.put(CalendarContract.Events.EVENT_TIMEZONE, timeZone.getID());

// Default calendar
values.put(CalendarContract.Events.CALENDAR_ID, 1);

values.put(CalendarContract.Events.RRULE, "FREQ=DAILY;UNTIL="
        + dtUntill);
// Set Period for 1 Hour
values.put(CalendarContract.Events.DURATION, "+P1H");

values.put(CalendarContract.Events.HAS_ALARM, 1);

// Insert event to calendar
Uri uri = cr.insert(CalendarContract.Events.CONTENT_URI, values);