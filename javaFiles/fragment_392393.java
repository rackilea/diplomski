public void updateUser(String email, String total_usage) {
    SQLiteDatabase db = this.getWritableDatabase();

    // Create a contentvalues array to store your values that will be updated
    ContentValues values = new ContentValues();
    values.put(KEY_TOTAL_USAGE, total_usage);

    // updating row
    db.update(TABLE_LOGIN, values, KEY_EMAIL + " = '" + email + "'",null);

    db.commit();
    db.close();
}