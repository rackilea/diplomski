public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "mydb";
    public static final int DBVERSION = 1;

    public static final String TABLE_NAME = "mytable";
    public static final String TABLE_NAME2 = "mytable2";
    public static final String UID = "uid";
    public static final String CNAME = "cname";
    public static final String FIRST_ATTRIBUTE = "a1";
    public static final String SECOND_ATTRIBUTE = "a2";
    public static final String THIRD_ATTRIBUTE = "a3";
    public static final String FOURTH_ATTRIBUTE = "a4";
    public static final String FIFTH_ATTRIBUTE = "a5";

    SQLiteDatabase mDB;

    public DBHelper(Context context) {
        super(context, DBNAME, null, DBVERSION);
        mDB = this.getWritableDatabase();
    }

    // Create both tables
    @Override
    public void onCreate(SQLiteDatabase db) {

        String crt_tbl = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(" +
                UID + " INTEGER PRIMARY KEY," +
                CNAME + " TEXT, " +
                FIRST_ATTRIBUTE + " INTEGER, " +
                SECOND_ATTRIBUTE + " INTEGER," +
                THIRD_ATTRIBUTE + " INTEGER, " +
                FOURTH_ATTRIBUTE + " INTEGER, " +
                FIFTH_ATTRIBUTE + " INTEGER" +
                ")";
        db.execSQL(crt_tbl);

        String crt_tbl2 = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME2 + "(" +
                UID + " INTEGER PRIMARY KEY," +
                CNAME + " TEXT, " +
                FIRST_ATTRIBUTE + " INTEGER DEFAULT 0, " +
                SECOND_ATTRIBUTE + " INTEGER DEFAULT 0," +
                THIRD_ATTRIBUTE + " INTEGER DEFAULT 0, " +
                FOURTH_ATTRIBUTE + " INTEGER DEFAULT 0, " +
                FIFTH_ATTRIBUTE + " INTEGER DEFAULT 0" +
                ")";
        db.execSQL(crt_tbl2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
    }

    // Generic Insert method
    public long insertRow(String table, String cname, int[] attributes) {
        String[] attribute_columns = new String[]{FIRST_ATTRIBUTE,SECOND_ATTRIBUTE,THIRD_ATTRIBUTE,FOURTH_ATTRIBUTE,FIFTH_ATTRIBUTE};
        ContentValues cv = new ContentValues();
        cv.put(CNAME,cname);
        for (int i=0; i < attributes.length; i++) {
            cv.put(attribute_columns[i],attributes[i]);
        }
        return mDB.insert(table,null,cv);
    }

    // Insert row into table 1 with all 5 attributes
    public long insertRow(String cname,int a1, int a2, int a3, int a4, int a5) {
        int[] attributes = new int[]{a1,a2,a3,a4,a5};
        return insertRow(TABLE_NAME,cname,attributes);
    }

    // Inert row in table 1 with first 2 attributes
    public long insertRow(String cname, int a1, int a2) {
        int[] attributes = new int[]{a1,a2};
        return insertRow(TABLE_NAME,cname,attributes);
    }

    // Insert row into table 2 with all 5 atributes
    public long insertRow2(String cname,int a1, int a2, int a3, int a4, int a5) {
        int[] attributes = new int[]{a1,a2,a3,a4,a5};
        return insertRow(TABLE_NAME2,cname,attributes);
    }

    // Insert row into table 2 with first 2 attributes
    public long insertRow2(String cname, int a1, int a2) {
        int[] attributes = new int[]{a1,a2};
        return insertRow(TABLE_NAME2,cname,attributes);
    }

    public void dumpTableToLog(String table) {
        Log.d("DUMPTABLE","Dumping table ==>" + table);
        Cursor csr = mDB.query(table,null,null,null,null,null,null);
        DatabaseUtils.dumpCursor(csr);
        csr.close();
    }
}