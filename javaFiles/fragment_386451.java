@Override
public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " +  TABLE_PRODUCTS + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_PRODUCTNAME + " TEXT, " +
                COLUMN_VENUE + " TEXT, " +
                COLUMN_DATEOFSTART + " TEXT, " +
                COLUMN_DATEOFEND + " TEXT, " +
                DURATION_WORKSHOP + " INTEGER, " +
                COST_WORKSHOP + " INTEGER " +
                 ");" ;
        db.execSQL(query);


 }