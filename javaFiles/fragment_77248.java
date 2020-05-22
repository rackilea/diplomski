String sql = "SELECT * FROM myTable";
Cursor cursor = mDbHelper.rawQuery(sql, null);
if(cursor != null){
    if(cursor.getCount() > 0){
        do {
             // get value
        } while(cursor.moveToNext());
    }
    cursor.close(); // close your cursor when you don't need it anymore
}