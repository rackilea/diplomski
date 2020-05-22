private static final String DATABASE_CREATE = 
    "CREATE TABLE " + TABLE_LOCATIONS + " (" + 
    ID_COL + " integer primary key autoincrement, " +
    COLUMN_NAME + " text, " + // The missing column name
    TITLE + " text, " +
    SNIPPET + " text, " + 
    POSITION + " text)";