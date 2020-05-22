private final static DB_PATH = Environment.getExternalStorageDirectory();
private final static DB_NAME = "my_database";

public DBHelper(Context ctx)
{
    database = SQLiteDatabase.openDatabase(DB_PATH + "/" + DB_NAME, null, SQLiteDatabase.OPEN_READWRITE);
}