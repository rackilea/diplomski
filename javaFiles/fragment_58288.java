public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "mydb";
    public static final int DBVERSION = 1;


    public DBHelper(Context context) {
        super(context, DBNAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TermDbSchema.TermTable.NAME + "(" +
                "_id integer primary key autoincrement, " +
                TermDbSchema.TermTable.Cols.UUID + ", " +
                TermDbSchema.TermTable.Cols.TITLE + ", " +
                TermDbSchema.TermTable.Cols.START_DATE + ", " +
                TermDbSchema.TermTable.Cols.END_DATE +
                ")"
        );
        db.execSQL("create table " + TermDbSchema.CourseTable.NAME + "(" +
                "_id integer primary key autoincrement, " +
                TermDbSchema.CourseTable.Cols.UUID + ", " +
                TermDbSchema.CourseTable.Cols.TITLE + ", " +
                TermDbSchema.CourseTable.Cols.START_DATE + ", " +
                TermDbSchema.CourseTable.Cols.END_DATE + ", " +
                TermDbSchema.CourseTable.Cols.CHOSEN_START_DATE + ", " +
                TermDbSchema.CourseTable.Cols.CHOSEN_END_DATE + ", " +

                TermDbSchema.CourseTable.Cols.COURSE_STATUS + ", " +
                TermDbSchema.CourseTable.Cols.OPTIONAL_NOTE + ", " +
                TermDbSchema.CourseTable.Cols.MENTOR_NAME + ", " +
                TermDbSchema.CourseTable.Cols.MENTOR_PHONE + ", " +
                TermDbSchema.CourseTable.Cols.MENTOR_EMAIL + ", " +
                TermDbSchema.CourseTable.Cols.COL_COURSE_TERM_REFERENCE + " INTEGER REFERENCES " +
                TermDbSchema.TermTable.NAME + "(_id) ON DELETE CASCADE ON UPDATE CASCADE" + //<<<<<<<<<< ADDED
                ")"
        );
        db.execSQL("create table " + TermDbSchema.AssessmentTable.NAME + "(" +
                "_id integer primary key autoincrement, " +
                TermDbSchema.AssessmentTable.Cols.UUID + ", " +
                TermDbSchema.AssessmentTable.Cols.TITLE + ", " +
                TermDbSchema.AssessmentTable.Cols.ASSESS_TYPE + ", " +
                TermDbSchema.AssessmentTable.Cols.DUE_DATE + ", " +
                TermDbSchema.AssessmentTable.Cols.GOAL_DATE + ", " +
                TermDbSchema.AssessmentTable.Cols.COL_ASSESS_COURSE_REFERENCE + " INTEGER REFERENCES " + TermDbSchema.CourseTable.NAME + "(_id) ON DELETE CASCADE ON UPDATE CASCADE" + //<<<<<<<<<< ADDED
                ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.setForeignKeyConstraintsEnabled(true);

    }

    public long addTerm(String title, String start_date, String end_date) {
        ContentValues cv = new ContentValues();
        cv.put(TermDbSchema.TermTable.Cols.TITLE,title);
        cv.put(TermDbSchema.TermTable.Cols.START_DATE,start_date);
        cv.put(TermDbSchema.TermTable.Cols.END_DATE,end_date);
        return this.getWritableDatabase().insert(TermDbSchema.TermTable.NAME,null,cv);
    }

    public long addCourse(
            String title,
            String start_date,
            String end_date,
            String chosen_start_date,
            String chosen_end_date,
            String status, String note,
            String mentor_name,
            String mentor_phone,
            String mentor_email,
            long course_reference) {
        ContentValues cv = new ContentValues();
        cv.put(TermDbSchema.CourseTable.Cols.TITLE,title);
        cv.put(TermDbSchema.CourseTable.Cols.START_DATE,start_date);
        cv.put(TermDbSchema.CourseTable.Cols.END_DATE,end_date);
        cv.put(TermDbSchema.CourseTable.Cols.CHOSEN_START_DATE,chosen_start_date);
        cv.put(TermDbSchema.CourseTable.Cols.CHOSEN_END_DATE,chosen_end_date);
        cv.put(TermDbSchema.CourseTable.Cols.COURSE_STATUS,status);
        cv.put(TermDbSchema.CourseTable.Cols.OPTIONAL_NOTE,note);
        cv.put(TermDbSchema.CourseTable.Cols.MENTOR_NAME,mentor_name);
        cv.put(TermDbSchema.CourseTable.Cols.MENTOR_PHONE,mentor_phone);
        cv.put(TermDbSchema.CourseTable.Cols.MENTOR_EMAIL,mentor_email);
        cv.put(TermDbSchema.CourseTable.Cols.COL_COURSE_TERM_REFERENCE,course_reference);
        return this.getWritableDatabase().insert(TermDbSchema.CourseTable.NAME,null,cv);
    }

    public long addAssessment(
            String title,
            String assessType,
            String duedate,
            String goaldate,
            long course_reference) {
        ContentValues cv = new ContentValues();
        cv.put(TermDbSchema.AssessmentTable.Cols.TITLE, title);
        cv.put(TermDbSchema.AssessmentTable.Cols.ASSESS_TYPE,assessType);
        cv.put(TermDbSchema.AssessmentTable.Cols.DUE_DATE,duedate);
        cv.put(TermDbSchema.AssessmentTable.Cols.GOAL_DATE,goaldate);
        cv.put(TermDbSchema.AssessmentTable.Cols.COL_ASSESS_COURSE_REFERENCE,course_reference);
        return this.getWritableDatabase().insert(TermDbSchema.AssessmentTable.NAME,null,cv);
    }

    public Cursor getAllCoursesWithTermDetails() {
        String tables = TermDbSchema.CourseTable.NAME +
                " JOIN " + TermDbSchema.TermTable.NAME + " ON " +
                TermDbSchema.CourseTable.Cols.COL_COURSE_TERM_REFERENCE + " = " +
                TermDbSchema.TermTable.NAME + "." + "_id";
        return this.getWritableDatabase().query(tables,null,null,null,null,null,null);
    }

    public Cursor getAllAssessmentsWithCourseAndTermdetails() {
        String tables = TermDbSchema.AssessmentTable.NAME +
                " JOIN " + TermDbSchema.CourseTable.NAME + " ON " +
                TermDbSchema.AssessmentTable.Cols.COL_ASSESS_COURSE_REFERENCE + " = " +
                TermDbSchema.CourseTable.NAME + "." + "_id" +
                " JOIN " + TermDbSchema.TermTable.NAME + " ON " +
                TermDbSchema.CourseTable.Cols.COL_COURSE_TERM_REFERENCE + " = " +
                TermDbSchema.TermTable.NAME + "." + "_id";
        return this.getWritableDatabase().query(tables,null,null,null,null,null,null);
    }
}