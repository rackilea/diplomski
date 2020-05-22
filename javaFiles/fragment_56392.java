private boolean closeDB()
      {
        SQLiteDatabase localSQLiteDatabase = null;
        try
        {
          localSQLiteDatabase = SQLiteDatabase.openDatabase(DB_PATH + DB_NAME, null, 1);
          if (localSQLiteDatabase != null){
            localSQLiteDatabase.close();
            return true; // opended DB closed 
          }else{
            return false;//  no connections opened right now.
          }

        }
        catch (SQLiteException localSQLiteException){
      }