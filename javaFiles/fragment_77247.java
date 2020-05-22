String sql = "SELECT * FROM myTable";
Cursor cursor = mDbHelper.rawQuery(sql, null);
if(cursor != null){
    if(cursor.getCount() > 0){
        for(cursor.move(0);cursor.moveToNext();cursor.isAfterLast()){
            // get your data here
        }
    }
    cursor.close(); // close your cursor when you don't need it anymore
}