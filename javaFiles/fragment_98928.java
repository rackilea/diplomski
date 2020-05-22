public void onCreate(SQLiteDatabase arg0) {
        // TODO Auto-generated method stub
        try {
            db.execSQL(DATABASE_CREATE_TABLE1);
            db.execSQL(DATBASE_CREATE_TABLE2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }