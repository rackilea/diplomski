public class SafeDB extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "safedb.db";
    private static final String TABLE_NAME = "marked_safe";
    private static final String COL_ID = "id";
    private static final String COL_MAC = "mac";
    private static final String COL_MARK = "mark";

    //////////Housekeeping START
    public SafeDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, DB_NAME, factory, DB_VERSION);
    }
    public SafeDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db){
        String query = "CREATE TABLE " + TABLE_NAME + "(" +
                COL_ID + " INTEGER PRIMARY KEY, " + // AUTOINCREMENT REMOVED NOT NECESSARY
                COL_MAC + " TEXT UNIQUE, " + // Probably should be unique
                COL_MARK + " INTEGER " +
                ");";
        db.execSQL(query);
    }

    public void open() throws SQLException {
        close();
        this.getWritableDatabase();
    }

    public void closeDB() {
        SQLiteDatabase db = this.getReadableDatabase();
        if (db != null && db.isOpen())
            db.close();
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1){
        deleteTable(); // might as well use the deleteTable method as it exists
        onCreate(db);
    }
//////////Housekeeping END

    public void deleteTable(){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }

    //IF FIRST TIME. THIS WILL BE TRIGGERED
    // wont hurt to return the id of the inserted row (-1 if no row inserted)
    public long addSafeMaker(String mac, int mark){
        ContentValues values = new ContentValues();
        values.put(COL_MAC, mac);
        values.put(COL_MARK, mark);
        SQLiteDatabase db = getWritableDatabase();
        return db.insert(TABLE_NAME, null, values);
    }


    //UPDATE THE Arp
    public int updateMaker(String mac, int mark){
        ContentValues values = new ContentValues();
        values.put(COL_MARK, mark);
        //values.put(COL_MARK, mark); // guess this wont change rather that it will be used to determine the row to be updated
        SQLiteDatabase db = getWritableDatabase();
        //db.update(TABLE_NAME, values, "id = 1", null); // Will only ever update 1 specific row
        String whereclause = COL_MAC + "=?";
        String[] whereargs = new String[]{mac};
        return db.update(TABLE_NAME,values,whereclause,whereargs);
    }


    //GET THE MAC
    public String getMac(String x) {
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM "+ TABLE_NAME+" WHERE "+ COL_ID+" = '" + x+"'" + " LIMIT 1;" ;
        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();

        String mac = c.getString(c.getColumnIndex("mac"));
        return mac;
    }

    public boolean getSafeValue(String mac) {
        int mark = 0; // assume marked safe if row not found
        SQLiteDatabase db = this.getWritableDatabase();
        String whereclause = COL_MAC + "=?";
        String[] whereargs = new String[]{mac};
        Cursor c = db.query(TABLE_NAME,null,whereclause,whereargs,null,null,null);
        if (c.moveToFirst()) {
            mark = c.getInt(c.getColumnIndex(COL_MARK));
        }
        return mark < 1;
    }

    //GET THE BUTTON VISIBILITY VALUE
    /*
    public String getSafeValue(String x) {
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM "+ TABLE_NAME+" WHERE "+ COL_ID+" = '" + x+"'" + " LIMIT 1;" ;
        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();

        String mark = c.getString(c.getColumnIndex("mark"));
        return mark;
    }
    */

    //CHECK IF EMPTY
    /*
    public boolean isEmpty() {
        boolean e = true;
        SQLiteDatabase db = getWritableDatabase();
        String count = "SELECT count(*) FROM " + TABLE_NAME;
        Cursor c = db.rawQuery(count, null);
        c.moveToFirst(); // WARINING if no rows then next line will crash INDEX OUT OF BOUNDS
        int icount = c.getInt(0);
        e = icount <= 0;
        return e;
    }
    */

    public long getCount(){
        int count = 0;
        SQLiteDatabase db = getWritableDatabase();
        return DatabaseUtils.queryNumEntries(this.getWritableDatabase(),TABLE_NAME);
        /*
        quick form used as above
        String c = "SELECT count(*) FROM " + TABLE_NAME;
        Cursor x = db.rawQuery(c, null);
        x.moveToFirst();
        count = x.getInt(0);
        return count;
        */
    }
}