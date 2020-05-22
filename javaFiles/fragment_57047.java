public Cursor getNote(long rowId) throws SQLException {
        Cursor cursor = Db.query("notes", new String[] { "_ID",
                "TITLE", "NOTES"}, "_ID=1", null,
                null, null, null, null);

      cursor.moveToFirst();

      if(cursor.getCount() > 0)
      {
        //do stuff
      }
      else
      {
        //Empty cursor
      }

        return cursor;
    }