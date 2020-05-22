private List<CalendarEntry> readCalendar()
{
    // Fetch a list of all calendars synced with the device, their title and _id
    // Notice that there is selection deleted = 0.
    Cursor cursor = getContentResolver().query(Uri.parse("content://com.android.calendar/events"),
                (new String[]{"_id", "title"}), "deleted = ?", new String[]{"0"}, null);

    List<CalendarEntry> calendarIds = new ArrayList<CalendarEntry>();

    while (cursor.moveToNext())
    {
        int _id = cursor.getInt(0);
        String title = cursor.getString(1);
        calendarIds.add(new CalendarEntry(_id, title));
    }
    cursor.close();
    return calendarIds;
}