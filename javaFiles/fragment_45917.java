public int getContactsCount() {
    String countQuery = "SELECT  * FROM " + TABLE_WORDS;
    SQLiteDatabase db = this.getReadableDatabase();
    Cursor cursor = db.rawQuery(countQuery, null);
    cursor.close();
    // return count
    return cursor.getCount();
}