ArrayList<CollegeItem> arr = new ArrayList<>();
    String selectQuery = "SELECT  * FROM " + TABLE_NAME;

    SQLiteDatabase db = this.getReadableDatabase();
    Cursor cursor = db.rawQuery(selectQuery, null);
    // Move to first row
    cursor.moveToFirst();
    while (cursor.isAfterLast() == false)
    {
        arr.add(new CollegeItem(cursor.getString(1), 
        cursor.getString(2)); 
        cursor.moveToNext();
    }
    cursor.close();
    db.close();
    return arr;