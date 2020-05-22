public int getUserId(String userName) {
    SQLiteDatabase db = getReadableDatabase();
    String query = "SELECT userId FROM users WHERE userName = ?";
    String[] parameters = new String[] { userName };
    Cursor cursor = db.rawQuery(query, parameters);
    if (cursor.moveToFirst())
        return cursor.getInt(0);
    else
        return -1; // not found
}