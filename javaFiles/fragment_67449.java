@Override
public void onCreate(SQLiteDatabase db) {
    db.execSQL("CREATE TABLE IF NOT EXISTS" + TABLE_NAME + " (" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_DATE + " TEXT, " +
            COLUMN_EXERCISE + " TEXT, " +
            COLUMN_WEIGHT + " TEXT, " +
            COLUMN_REPS + " TEXT, " +
            COLUMN_SET_TIME + " TEXT, " +
            COLUMN_WORKOUT_TIME + " TEXT, " +
            COLUMN_DISTANCE + " TEXT, " +
            COLUMN_SPEED + " TEXT, " +
            COLUMN_REST_TIME + " TEXT, " +
            COLUMN_NUMBER_OF_SETS + " TEXT, " +
            COLUMN_FIELDS_PARAMETER + " TEXT, " +
            COLUMN_NOT_ON_LIST_EXERCISE + " TEXT, " +
            COLUMN_HERAT_BEAT + " TEXT, " +
            COLUMN_CALORIES + " TEXT, " +
            COLUMN_COMMENT + " TEXT);");

    db.execSQL("CREATE TABLE IF NOT EXISTS" + SECOND_TABLE_NAME + " (" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_AGE + " TEXT, " +
            COLUMN_AGE_PW + " TEXT, " +
            COLUMN_GENDER + " TEXT, " +
            COLUMN_HEIGHT + " TEXT, " +
            COLUMN_HEIGHT_PW + " TEXT, " +
            COLUMN_BODY_WEIGHT + " TEXT, " +
            COLUMN_BODY_WEIGHT_PW + " TEXT, " +
            COLUMN_PROFILE_PIC + " TEXT, " +
            COLUMN_FAT + " TEXT, " +
            COLUMN_FAT_PW + " TEXT);");

    db.execSQL("CREATE TABLE IF NOT EXISTS" +  MEDIA_TABLE + " (" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_PICS + " TEXT, " +
            COLUMN_VIDEO + " TEXT);");

}       

@Override
public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    db.execSQL("DROP TABLE IF EXISTS " + SECOND_TABLE_NAME);
    db.execSQL("DROP TABLE IF EXISTS " + MEDIA_TABLE);
    onCreate(db);   
}