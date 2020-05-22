public void deleteItem(String id)
   {
      SQLiteDatabase db = getWritableDatabase();
      db.delete(TABLE_NAME, _ID + "=?", new String[]
      { id });
      db.close();
   }