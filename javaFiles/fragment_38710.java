// Database creation sql statement
  private static final String DATABASE_CREATE = "create table "
  + TABLE_COMMENTS + "(" + COLUMN_ID
  + " integer primary key autoincrement, " + COLUMN_COMMENT
  + " TEXT," + COLUMN_NUMBER + " TEXT," 
  + COLUMN_BLOCK +" TEXT," +"UNIQUE(COLUMN_NUMBER) ON CONFLICT REPLACE"+ ");";