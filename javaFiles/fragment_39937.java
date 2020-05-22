public void insertData(String name, String name1) {
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues contentValues = new ContentValues();
    contentValues.put("name",name);
    contentValues.put("name1",name1);
    long result = db.insert(TABLE_NAME,null ,contentValues);
}