@Override
    public void onCreate(SQLiteDatabase db) {
        //INFORMATION ABOUT EACH COLUMN FOR THE TABLE
        String query="CREATE TABLE "+TABLE_PRODUCTS+"("+
                COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                COLUMN_TITLE+" TEXT, "+
                COLUMN_DATERELEASED+"TEXT, "+
                COLUMN_FILENAME+" TEXT "
                +" ); ";
        db.execSQL(query);
    }