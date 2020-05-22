public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs,
                    String sortOrder) {
    SQLiteDatabase database = mDbHelper.getReadableDatabase();

    // This cursor will hold the result of the query
    Cursor cursor = null;

    int match = sUriMatcher.match(uri);
    switch (match) {
        case REMINDER:
            cursor = database.query(AlarmReminderContract.AlarmReminderEntry.TABLE_NAME, 
                    null, //<<<<<<<<<< CHANGED 
                    selection, 
                    selectionArgs,
                    null, null, sortOrder);
            Log.i("msg","Reminder Invoked");
            break;
        case REMINDER_ID:
            selection = AlarmReminderContract.AlarmReminderEntry._ID + "=?";
            selectionArgs = new String[] { String.valueOf(ContentUris.parseId(uri)) };


            cursor = database.query(AlarmReminderContract.AlarmReminderEntry.TABLE_NAME, 
                    null, //<<<<<<<<<< CHANGED 
                    selection, 
                    selectionArgs,
                    null, null, sortOrder);
            break;
        default:
            throw new IllegalArgumentException("Cannot query unknown URI " + uri);
    }
}