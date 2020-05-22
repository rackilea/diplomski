public List<Notes> getNotesByUser(long usermap) {

    List<Notes> notes = new ArrayList<>();
    SQLiteDatabase db = this.getReadableDatabase();
    Cursor cursor = db.query(TABLE_NAME,
            new String[]{Notes.NOTE_COLUMN_ID, Notes.COLUMN_NOTE,Notes.NOTE_COLUMN_USERMAP},
            Notes.NOTE_COLUMN_USERMAP + "=?",
            new String[]{String.valueOf(usermap)}, null, null, null, null);
    while(cursor.moveToNext()) {
        notes.add(new Notes(cursor.getInt(cursor.getColumnIndex(Notes.NOTE_COLUMN_ID)),
            cursor.getString(cursor.getColumnIndex(Notes.COLUMN_NOTE)),
            cursor.getLong(cursor.getColumnIndex(Notes.NOTE_COLUMN_USERMAP)))
        );
    }
    cursor.close();
    return notes;
}