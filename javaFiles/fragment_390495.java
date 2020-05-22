String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER 
            + "(" 
            + KEY_ID      + " INTEGER PRIMARY KEY AUTOINCREMENT, " 
            + KEY_NAME    + " TEXT, "
            + KEY_EMAIL   + " TEXT, " 
            + KEY_PW      + " TEXT, "
            + KEY_SESSION + " INTEGER "
            + ")";

    String CREATE_EXPENSE_TYPE_TABLE = "CREATE TABLE " + TABLE_EXPENSE_TYPE
            + "(" 
            + KEY_EXPENSE_ID   + " INTEGER AUTOINCREMENT, "
            + KEY_EXPENSE_TYPE + " TEXT PRIMARY KEY "
            + ")";