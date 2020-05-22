public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "mydb";
    public static final int DBVERSION = 1;
    public static final String TB_DAYENTRIES = "day_entries";
    public static final String DAYENTRIES_COL_DATE = "_date";
    public static final String DAYENTRIES_COL_CB01 = "_cb01";
    public static final String DAYENTRIES_COL_CB02 = "_cb02";
    public static final String DAYENTRIES_COL_CB03 = "_cb03";
    public static final String DAYENTRIES_COL_CB04 = "_cb04";
    public static final String DAYENTRIES_COL_CB05 = "_cb05";
    public static final String DAYENTRIES_COL_CB06 = "_cb06";
    public static final String DAYENTRIES_COL_CB07 = "_cb07";
    public static final String DAYENTRIES_COL_CB08 = "_cb08";
    public static final String DAYENTRIES_COL_CB09 = "_cb09";
    public static final String DAYENTRIES_COL_CB10 = "_cb10";


    SQLiteDatabase mDB;
    public DBHelper(Context context) {
        super(context, DBNAME, null, DBVERSION);
        mDB = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String crt_tbl_sql = "CREATE TABLE IF NOT EXISTS " + TB_DAYENTRIES + "(" +
                DAYENTRIES_COL_DATE + " TEXT PRIMARY KEY NOT NULL," +
                DAYENTRIES_COL_CB01 + " INTEGER DEFAULT 0," +
                DAYENTRIES_COL_CB02 + " INTEGER DEFAULT 0," +
                DAYENTRIES_COL_CB03 + " INTEGER DEFAULT 0," +
                DAYENTRIES_COL_CB04 + " INTEGER DEFAULT 0," +
                DAYENTRIES_COL_CB05 + " INTEGER DEFAULT 0," +
                DAYENTRIES_COL_CB06 + " INTEGER DEFAULT 0," +
                DAYENTRIES_COL_CB07 + " INTEGER DEFAULT 0," +
                DAYENTRIES_COL_CB08 + " INTEGER DEFAULT 0," +
                DAYENTRIES_COL_CB09 + " INTEGER DEFAULT 0," +
                DAYENTRIES_COL_CB10 + " INTEGER DEFAULT 0" +
                ")";
        db.execSQL(crt_tbl_sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public long addNewDayEntry(String date) {
        ContentValues cv = new ContentValues();
        cv.put(DAYENTRIES_COL_DATE,date);
        return mDB.insert(TB_DAYENTRIES,null,cv);
    }

    public int setDayEntryForOneCheckBox(String date, int checkbox) {
        int rv = 0;
        String whereclause = DAYENTRIES_COL_DATE + "=?";
        String[] whereargs = new String[]{date};
        ContentValues cv = new ContentValues();
        switch (checkbox) {
            case 1:
                cv.put(DAYENTRIES_COL_CB01,1);
                break;
            case 2:
                cv.put(DAYENTRIES_COL_CB02,1);
                break;
            case 3:
                cv.put(DAYENTRIES_COL_CB03,1);
                break;
            case 4:
                cv.put(DAYENTRIES_COL_CB04,1);
                break;
            case 5:
                cv.put(DAYENTRIES_COL_CB05,1);
                break;
            case 6:
                cv.put(DAYENTRIES_COL_CB06,1);
                break;
            case 7:
                cv.put(DAYENTRIES_COL_CB07,1);
                break;
            case 8:
                cv.put(DAYENTRIES_COL_CB08,1);
                break;
            case 9:
                cv.put(DAYENTRIES_COL_CB09,1);
                break;
            case 10:
                cv.put(DAYENTRIES_COL_CB10,1);
                break;
        }
        if (cv.size() == 1) {
            rv = mDB.update(TB_DAYENTRIES,cv,whereclause,whereargs);
        }
        return rv;
    }

    public boolean isDayEntryCheckboxSet(String date, int checkbox) {
        boolean rv = false;
        String whereclause = DAYENTRIES_COL_DATE + "=?";
        String[] whereargs = new String[]{date};
        if (checkbox < 1 || checkbox > 10) {
            return rv;
        }
        Cursor csr = mDB.query(TB_DAYENTRIES,null,whereclause,whereargs,null,null,null);
        if (csr.moveToFirst()) {
            rv = csr.getInt(csr.getColumnIndex(getCheckboxColumnNameFromNumber(checkbox))) == 1;
        }
        csr.close();
        return rv;
    }

    private String getCheckboxColumnNameFromNumber(int checkbox) {
        switch (checkbox) {
            case 1:
                return DAYENTRIES_COL_CB01;
            case 2:
                return DAYENTRIES_COL_CB02;
            case 3:
                return DAYENTRIES_COL_CB03;
            case 4:
                return DAYENTRIES_COL_CB04;
            case 5:
                return DAYENTRIES_COL_CB05;
            case 6:
                return DAYENTRIES_COL_CB06;
            case 7:
                return DAYENTRIES_COL_CB07;
            case 8:
                return DAYENTRIES_COL_CB08;
            case 9:
                return DAYENTRIES_COL_CB09;
            case 10:
                return DAYENTRIES_COL_CB10;
        }
        return "";
    }
}