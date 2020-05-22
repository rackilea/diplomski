String sql = "SELECT * FROM myTable";
Cursor cursor = mDbHelper.rawQuery(sql, null);
if(cursor != null){
    cursor.moveToFirst();
    String myString = cursor.getString(cursor.getColumnIndex("title"));
    cursor.close(); // close your cursor when you don't need it anymore
}