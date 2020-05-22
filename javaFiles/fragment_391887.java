private static class MyDbHelper extends SQLiteOpenHelper
{

    public MyDbHelper(Context context, String description, CursorFactory factory, int version)
    {
        super(context, description, factory, version);          
    }

    @Override
    public void onCreate(SQLiteDatabase _db)
    {
        _db.execSQL(CREATE_TABLE_1);
        _db.execSQL(CREATE_TABLE_2);
        _db.execSQL(CREATE_TABLE_3);
        ..etc
    }

    @Override
    public void onUpgrade(SQLiteDatabase _db, int oldVersion, int newVersion)
    {
        // Log the version upgrade.
        Log.w("MyDbAdapter", "Upgrading from version " + oldVersion + " to " +
                newVersion + ", which will destroy all old data.");

        _db.execSQL("DROP TABLE IF EXISTS " + TBL_ONE);
        _db.execSQL("DROP TABLE IF EXISTS " + TBL_TWO);
        _db.execSQL("DROP TABLE IF EXISTS " + TBL_THREE);

        onCreate(_db);          
    }

}