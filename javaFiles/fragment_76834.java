@Override
public void onCreate(SQLiteDatabase db){
    db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
            COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL_NAME + " TEXT," +
            COL_AGE + " INTEGER NOT NULL DEFAULT 0, " +
            COL_GENDER + " INTEGER NOT NULL DEFAULT 0, " +
            COL_TRAUMA + " INTEGER NOT NULL DEFAULT 0, " +
            COL_WEIGHT + " INTEGER NOT NULL DEFAULT 0, " +
            COL_HEIGHT + " INTEGER NOT NULL DEFAULT 0);");
}