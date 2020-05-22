public boolean updatePassword(String username, String password) {
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues values = new ContentValues();
    values.put(KEY_PASSWORD, password);
    int rows = db.update(TABLE_USERS, values,  "username = ?" , new String[] {username} );
    db.close();
    return (rows > 0);
}