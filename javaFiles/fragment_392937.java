public Notes getNote(long id) {

    Notes notes;
    SQLiteDatabase db = this.getReadableDatabase();
    Cursor cursor = db.query(TABLE_NAME,
            new String[]{Notes.NOTE_COLUMN_ID, Notes.COLUMN_NOTE,Notes.NOTE_COLUMN_USERMAP},
            Notes.NOTE_COLUMN_ID + "=?",
            new String[]{String.valueOf(id)}, null, null, null, null);

    if (cursor.moveToFirst()) {

        notes = new Notes(
            cursor.getInt(cursor.getColumnIndex(Notes.NOTE_COLUMN_ID)),
            cursor.getString(cursor.getColumnIndex(Notes.COLUMN_NOTE)),
            cursor.getLong(cursor.getColumnIndex(Notes.NOTE_COLUMN_USERMAP))
        );
    }

    cursor.close();
    return notes;
}