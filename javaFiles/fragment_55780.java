public long insertTimeSheet(String name,String weather,String date,String status){
  database=dbHelper.getWritableDatabase();
  ContentValues values=new ContentValues();
  values.put(MyDatabaseHelper.Name,name);
  values.put(MyDatabaseHelper.Weather,weather);
  values.put(MyDatabaseHelper.Date,date);
  values.put(MyDatabaseHelper.Status, status);
  database.insert(MyDatabaseHelper.TABLE_INFO, null, values);
  Cursor cursor = database.rawQuery("SELECT MAX(ID) FROM "+ MyDatabaseHelper.TABLE_INFO, null);
  if(cursor.getCount()>0){
    cursor.moveToFirst();
    return cursor.getLong(0);
  }

  return 0;
}