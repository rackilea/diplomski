public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "acedema";
    public static final int DBVERSION = 1;
    public static final String TB_CLASSES = "classes";
    public static final String COL_CLASS_ID = BaseColumns._ID;
    public static final String COL_CLASS_ITEM_INDEX = "class_item_index";
    public static final String COL_CLASS_NAME = "class_name";
    public static final String COL_CLASS_CODENAME = "class_codename";
    public static final String COL_CLASS_SECTIONS = "class_section";
    public static final String COL_CLASS_TEACHERS = "class_teachers";
    public static final String COL_CLASS_STUDENTS = "class_students";

    SQLiteDatabase mDB;


    public DBHelper(Context context) {
        super(context, DBNAME, null, DBVERSION);
        mDB = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String crtsql = "CREATE TABLE IF NOT EXISTS " + TB_CLASSES +
                "(" +
                COL_CLASS_ID + " INTEGER PRIMARY KEY, " +
                COL_CLASS_ITEM_INDEX + " NUMBER, " +
                COL_CLASS_NAME + " TEXT, " +
                COL_CLASS_CODENAME + " TEXT, " +
                COL_CLASS_SECTIONS + " TEXT, " +
                COL_CLASS_TEACHERS + " TEXT, " +
                COL_CLASS_STUDENTS + " TEXT " +
                ")";
        db.execSQL(crtsql);


    }

    public long insertClass(int item_index, String classname, String classcode, String classsections, String classteachers, String classstudents) {
        ContentValues cv = new ContentValues();
        cv.put(COL_CLASS_ITEM_INDEX,item_index);
        cv.put(COL_CLASS_NAME,classname);
        cv.put(COL_CLASS_CODENAME,classcode);
        cv.put(COL_CLASS_SECTIONS,classsections);
        cv.put(COL_CLASS_TEACHERS,classteachers);
        cv.put(COL_CLASS_STUDENTS,classstudents);
        return mDB.insert(TB_CLASSES,null,cv);
    }

    public int deleteAClass(long id) {
        String whereclause = COL_CLASS_ID + "=?";
        String[] whereargs = new String[]{String.valueOf(id)};
        return mDB.delete(TB_CLASSES,whereclause,whereargs);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public List<ClassesBean> getClasses() {

        ArrayList<ClassesBean> rv = new ArrayList<ClassesBean>();
        Cursor csr = mDB.query(TB_CLASSES,null,null,null,null,null,null);
        while (csr.moveToNext()) {
            ClassesBean cb = new ClassesBean();
            cb.setId(csr.getLong(csr.getColumnIndex(COL_CLASS_ID)));
            cb.setClasses_item_index(csr.getInt(csr.getColumnIndex(COL_CLASS_ITEM_INDEX)));
            cb.setClasses_name(csr.getString(csr.getColumnIndex(COL_CLASS_NAME)));
            cb.setClasses_codename(csr.getString(csr.getColumnIndex(COL_CLASS_CODENAME)));
            cb.setClasses_sections(csr.getString(csr.getColumnIndex(COL_CLASS_SECTIONS)));
            cb.setClasses_teachers(csr.getString(csr.getColumnIndex(COL_CLASS_TEACHERS)));
            cb.setClasses_students(csr.getString(csr.getColumnIndex(COL_CLASS_STUDENTS)));
            rv.add(cb);
        }
        return rv;
    }
}