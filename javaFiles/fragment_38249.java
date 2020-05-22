@Override
public void onCreate(SQLiteDatabase db) {
    db.execSQL("CREATE TABLE STORIES( " +
            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "uniq_id TEXT, " +
            "title TEXT, " +
            "body TEXT, " +
            "is_private INT, '" +
            "dev_id TEXT, " +
            "user_id TEXT, " +
            "date_time TEXT)");
}