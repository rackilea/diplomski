public int getCattleCount(){
    String countQuery = "SELECT  * FROM " + TABLE_CATTLE;
    SQLiteDatabase db = this.getReadableDatabase();
    Cursor cursor = db.rawQuery(countQuery, null);
    int count = cursor.getCount();
    cursor.close();
    db.close();
    return count;
}