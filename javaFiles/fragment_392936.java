public long insertNote(String note, long userMap) {
    SQLiteDatabase db = this.getWritableDatabase();

    ContentValues values = new ContentValues();
    values.put(Notes.COLUMN_NOTE, note);
    values.put(Notes.NOTE_COLUMN_USERMAP,userMap);

    long id = db.insert(TABLE_NAME, null, values);
    db.close();
    return id;
}