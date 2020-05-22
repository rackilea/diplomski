public int getUserID() {
    String qry = "SELECT id FROM " + TABLE_LOGIN;
    SQLiteDatabase db = this.getReadableDatabase();     
    Cursor cursor = db.rawQuery(qry, null);
    int res = id.getInt(id.getColumnIndex("id"));
    cursor.close();
    return res;
}