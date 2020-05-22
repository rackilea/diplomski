public String getEmail(String COLUMN_EMAIL)
{
    m_db = this.getReadableDatabase();
    Cursor cursor = m_db.query(TABLE_USERS, new String[]{COLUMN_EMAIL}, null, null,
            null, null, null);
    cursor.moveToFirst(); //<<<<<<<<<< WRONG
    String user = cursor.getString(cursor.getColumnIndex(COLUMN_EMAIL));
    cursor.close();
    return user;
}