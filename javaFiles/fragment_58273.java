public boolean insertData(String cf, String name, String surname, String sex, String year,
                          String month, String day, String place) {
    String date = day + "/" + month + "/" + year;
    SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
    ContentValues contentValues = new ContentValues();
    contentValues.put(CF, cf);
    contentValues.put(COL1, name);
    contentValues.put(COL2, surname);
    contentValues.put(COL3, sex);
    contentValues.put(COL4, date);
    contentValues.put(COL5, place);
    int id = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
    sqLiteDatabase.close();

    return (id != -1);

}