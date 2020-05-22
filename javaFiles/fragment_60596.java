String CREATE_ACTIVITIES_TABLE = 
            "CREATE TABLE " + TABLE_ACTIVITIES + 
            "(" + 
            KEY_ID + " INTEGER PRIMARY KEY," + 
            KEY_FRIEND + " TEXT," +
            KEY_DESCRIPTION + " TEXT," + 
            KEY_DAY + " TEXT," +    //<<<<<<<< added comma 
            KEY_MONTH + " TEXT," +  //<<<<<<<< added comma
            KEY_YEAR + " TEXT," +   //<<<<<<<< added comma 
            KEY_FRIEND_ID + " TEXT" +
            ")";
        db.execSQL(CREATE_ACTIVITIES_TABLE);