private SQLiteDatabase db;  
private MyDbHelper dbHelper;

public MyDbAdapter(Context context)
{       
    dbHelper = new MyDbHelper(context, DATABASE_NAME, null, DB_VERSION);
}


public MyDbAdapter open() throws SQLException
{
    try
    {
        db = dbHelper.getWritableDatabase();
    }
    catch (SQLiteException ex)
    {
        db = dbHelper.getReadableDatabase();
    }

    return this;
}

public void close()
{
    db.close();
}