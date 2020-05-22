public static final String DBNAME = "mydb";
public static final int DBVERSION = 1;

public static final String TABLE_NAME = "mytable";
public static final String COL1 = "col1";
public static final String COL2 = "col2";

SQLiteDatabase db;

private static final String CRT_MYTABLE_SQL = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME +
        "(" +
        COL1 + " TEXT, " +
        COL2 + " TEXT" +
        ")";
public DataBaseHelper(Context context) {
    super(context, DBNAME, null, DBVERSION);
    db = this.getWritableDatabase();
}

@Override
public void onCreate(SQLiteDatabase db) {
    db.execSQL(CRT_MYTABLE_SQL);
}

@Override
public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

}

public long addMytableRow(String col1, String col2) {
    ContentValues cv = new ContentValues();
    cv.put(COL1,col1);
    cv.put(COL2,col2);
    return db.insert(TABLE_NAME,null,cv);
}

public ArrayList<String> getData() {
    ArrayList<String> rv = new ArrayList<>();
    Cursor csr = db.query(TABLE_NAME,null,null,null,null,null,null);
    while (csr.moveToNext()) {
        rv.add(csr.getString(csr.getColumnIndex(COL2)));
    }
    csr.close();
    return rv;
}

public void deleteTaskByCol2(String task) {
    db.delete(TABLE_NAME,COL2 + "=?",new String[]{task});
}