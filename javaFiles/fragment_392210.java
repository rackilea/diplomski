public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "mydb";
    public static final int DBVERSION = 1;

    public static final String TB_TEST1 = "test1";

    public static final String COL_TEST1_ID = BaseColumns._ID;
    public static final String COL_TEST1_NAME = "_name";
    public static final String COL_TEST1_EMAIL = "_email";
    private static final String crtTest1SQL = "CREATE TABLE IF NOT EXISTS " +
            TB_TEST1 +
            "(" +
            COL_TEST1_ID + " INTEGER PRIMARY KEY," +
            COL_TEST1_NAME + " TEXT," +
            COL_TEST1_EMAIL + " TEXT" +
            ")";


    SQLiteDatabase mDB;


    public DBHelper(Context context) {
        super(context, DBNAME, null, DBVERSION);
        mDB = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(crtTest1SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
    }

    public long addTest1Row(String name, String email) {
        ContentValues cv = new ContentValues();
        cv.put(COL_TEST1_NAME,name);
        cv.put(COL_TEST1_EMAIL,email);
        return mDB.insert(TB_TEST1,null,cv);
    }

    public Cursor getCSVRows(String table) {
        Cursor rv;
        String[] columns;
        switch (table) {
            case TB_TEST1:
                columns = new String[]{COL_TEST1_ID + "||','||" + COL_TEST1_NAME + "||','||" + COL_TEST1_EMAIL};
                break;
                default:
                    return null;
        }
        return mDB.query(table,columns,null,null,null,null,null);
    }

    public String getColumnsAsCSV(String table) {
        StringBuilder sb = new StringBuilder("");
        if (ifTableExists(table)) {
            Cursor csr = mDB.rawQuery("PRAGMA table_info(" +
                    table +
                    ")",null);
            boolean after_first_row = false;
            int rowsdone = 0;
            while (csr.moveToNext()) {
                if (after_first_row) {
                    sb.append(",");
                } else {
                    after_first_row = true;
                }
                sb.append(csr.getString(csr.getColumnIndex("name")));
            }
        }
        return sb.toString();
    }

    private boolean ifTableExists(String table) {
        String whereclause = "name=?";
        String[] whereargs = new String[]{table};
        Cursor csr = mDB.query("sqlite_master",null,whereclause,whereargs,null,null,null);
        int rowcount = csr.getCount();
        csr.close();
        return rowcount > 0;
    }
}