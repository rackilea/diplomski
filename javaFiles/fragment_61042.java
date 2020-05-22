public int  getMinId(){
    int minId = null;
    String selectQuery = "SELECT * FROM " + TABLE_RESOURCES + " " + KEY_ID +" ORDER BY ASC LIMIT 1";

    SQLiteDatabase db = this.getReadableDatabase();
    Cursor cursor = db.rawQuery(selectQuery,null);

    cursor.moveToFirst();
    if(cursor.getCount() > 0){

        minId= cursor.getInt(0);

    }
    cursor.close();
    db.close();

    return minId;
}