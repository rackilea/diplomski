SQLiteDatabase sqLiteDatabase;
sqLiteDatabase=dbHelper.getReadableDatabase();

    Cursor c = sqLiteDatabase.query("QuizTable1", null, null, null, null, null, null);
    if( c.moveToNext() )
    {
      c.getString(0);
    }