public String getEmail(String COLUMN_EMAIL) {
    String user = "No Email Found."; //<<<<<<<<<< Default value in case of empty table
    m_db = this.getReadableDatabase();
    Cursor cursor = m_db.query(TABLE_USERS, new String[]{COLUMN_EMAIL}, null, null,
            null, null, null);
    if (cursor.moveToFirst()) { //<<<<<<<<<< checks result of the move
        user = cursor.getString(cursor.getColumnIndex(COLUMN_EMAIL));
    }
    cursor.close();
    return user;
}