public boolean updateRow(Integer task1, Integer task3) {
    String where = KEY_TASK1 + "=" + task1;
    ContentValues newValues = new ContentValues();
    newValues.put(KEY_TASK3, task3);
    SQLiteDatabase db1 = this.getWritableDatabase();
    // Insert it into the database. 
    return db.update(DATABASE_TABLE, newValues, KEY_TASK1+"=?", new String[]{task1}) != 0;
}