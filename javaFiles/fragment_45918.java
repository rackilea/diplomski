public int getContactsCount() {
    String countQuery = "SELECT COUNT(*) FROM " + TABLE_WORDS;
    SQLiteDatabase db = this.getReadableDatabase();
    Cursor cursor = db.rawQuery(countQuery, null);
    int count = -1;
    if (cursor.moveToFirst()) {
        count = cursor.getInt(0);
    }
    cursor.close();
    return count;
}