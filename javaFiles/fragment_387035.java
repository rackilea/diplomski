int deleterow(long id) {
    SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
    sqLiteDatabase.delete("mytab",
        "Id=?,
        new String[]{Long.toString(id)});
}