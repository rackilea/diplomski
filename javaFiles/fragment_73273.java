private static final String DATABASE_CREATE_SQL = 
        "CREATE TABLE " + DATABASE_TABLE 
        + " (" + KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
        + KEY_INGREDIENTNAME + " TEXT NOT NULL, "
        + KEY_IMAGE + " TEXT,"
        + KEY_DETAILS + " TEXT"
        + ");";