@Override
  public void onCreate(SQLiteDatabase db) {
    try {
      db.beginTransaction();
      db.execSQL("CREATE TABLE constants (_id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, value REAL);");

      ContentValues cv=new ContentValues();

      cv.put(TITLE, "Gravity, Death Star I");
      cv.put(VALUE, SensorManager.GRAVITY_DEATH_STAR_I);
      db.insert("constants", TITLE, cv);

      cv.put(TITLE, "Gravity, Earth");
      cv.put(VALUE, SensorManager.GRAVITY_EARTH);
      db.insert("constants", TITLE, cv);

      // several more inserts here

      cv.put(TITLE, "Gravity, Venus");
      cv.put(VALUE, SensorManager.GRAVITY_VENUS);
      db.insert("constants", TITLE, cv);

      db.setTransactionSuccessful();
    }
    finally {
      db.endTransaction();
    }
  }