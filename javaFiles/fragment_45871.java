@Override
 public void onCreate(SQLiteDatabase db) {

    String query = "CREATE TABLE "
               + TABLE_NAME
               + "(id INTEGER PRIMARY KEY AUTOINCREMENT, duration TIME, date DATE,          current_time TIME)";
    db.execSQL(query);
    }
 }

@Override
public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

}

 OpenHelper(Context context) {
     super(context, DATABASE_NAME, null, DATABASE_VERSION);
 }
}