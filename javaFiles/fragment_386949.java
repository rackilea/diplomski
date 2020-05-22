private static class DatabaseHelper extends SQLiteOpenHelper{
    DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db){
          db.execSQL(CREATE_PLAYER_TABLE);
          db.execSQL(CREATE_CATEGORY_TABLE);
    }
    public void onUpgrade(SQLiteDatabase db, int arg1, int arg2{
          db.execSQL("DROP TABLE IF EXISTS " + CREATE_PLAYER_TABLE);
          db.execSQL("DROP TABLE IF EXISTS " + CREATE_CATEGORY_TABLE);
          onCreate(db);
    }