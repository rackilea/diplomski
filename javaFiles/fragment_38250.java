@Override
public void onCreate(SQLiteDatabase db) {
    db.execSQL("CREATE TABLE STORIES( " +
            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "uniq_id TEXT, " +
            "title TEXT, " +
            "body TEXT, " +
            "is_private INTEGER, " +
            "dev_id TEXT, " +
            "user_id TEXT, " +
            "date_time TEXT)");
}