public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE=
                "CREATE TABLE"+
                        " "+Helper.TABLE_NAME+" "+
                        "("
                        +Helper.NAME+" "+"TEXT," //add space before column data type
                        +Helper.USERNAME+" "+"TEXT,"
                        +Helper.PASSWORD+" "+"TEXT);";
        db.execSQL(CREATE_TABLE);
        Toast.makeText(context, "database create", Toast.LENGTH_LONG).show();
    }