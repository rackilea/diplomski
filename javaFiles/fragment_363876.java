public static final String USER_TABLE = "USER_TABLE";

db.execSQL("CREATE TABLE " + USER_TABLE+
        "(_id INTEGER PRIMARY KEY AUTOINCREMENT,"
        + FFDBSchema.Colz.MODE_ID_COL + "TEXT DEFAULT NULL,"
        + FFDBSchema.Colz.TABLE_ID_COL + "TEXT DEFAULT '" +USER_TABLE+"',"
        + FFDBSchema.Colz.ANOTHER_TABLE+ "TEXT,"  +