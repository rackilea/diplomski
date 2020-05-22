/**
    * Use this method to return a single item object based on it's id
    * NOTE - from calling classes id may not be equal to position
    * @param id - the ID of the device being requested
    * @param db - the database to get it from
    * @return YOUR_ITEM - that device associated with the id
    */
   public static YOUR_ITEM getById(String id, SQLiteDatabase db)
   {
      String[] args = { id };
      Cursor c = db.rawQuery( "SELECT * FROM YOUR_TABLE WHERE " + 
                              BaseColumns._ID + "=?", args );
      c.moveToFirst();
      Item result = new Item().loadFrom(c);
      c.close();
      return (result);
   }