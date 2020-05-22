private void deleteEvent(int eventId)
{
    Uri CALENDAR_URI = Uri.parse("content://com.android.calendar/events");
    Uri uri = ContentUris.withAppendedId(CALENDAR_URI, eventId);
    getContentResolver().delete(uri, null, null);
}