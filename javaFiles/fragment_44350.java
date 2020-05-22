public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "quiz";
    private static final String TABLE_NAME = "worldhistory";
    private static final String KEY_ID = "id";
    private static final String QUESTIONS = "question";
    private static final String ANSWER = "answer";
    private static final String OPTIONA = "optiona";
    private static final String OPTIONB = "optionb";
    private static final String OPTIONC = "optionc";
    private static final String OPTIOND = "optiond";

    private SQLiteDatabase dba;

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + QUESTIONS + " TEXT, "
                + ANSWER + " TEXT, " + OPTIONA + " TEXT, " + OPTIONB + " TEXT, " + OPTIONC
                + " TEXT, " + OPTIOND + " TEXT)";

        db.execSQL(CREATE_TABLE);

        addQuestions(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXITS " + TABLE_NAME);
        onCreate(db);
    }

    // creating the questions, options, and answers
    private void addQuestions(SQLiteDatabase db) {
        Question q1 = new Question("World War I began in which year?", "1923",
                "1938", "1917", "1914", "D");
        this.addQuestion(q1, db);

        Question q2 = new Question("Adolf Hitler was born in which country?",
                "France", "Germany", "Austria", "Hungary", "C");
        this.addQuestion(q2, db);

        //add more questions
    }

    // addding new questions to db
    public void addQuestion(Question question, SQLiteDatabase db) {
        ContentValues values = new ContentValues();
        values.put(QUESTIONS, question.getQuestion());
        values.put(ANSWER, question.getAnswer());
        values.put(OPTIONA, question.getOptionA());
        values.put(OPTIONB, question.getOptionB());
        values.put(OPTIONC, question.getOptionC());
        values.put(OPTIOND, question.getOptionD());

        db.insert(TABLE_NAME, null, values);
    }

    public List<Question> getAllQuestions() {
        List<Question> questionList = new ArrayList<Question>();

        String query = "SELECT * FROM " + TABLE_NAME;
        dba = this.getReadableDatabase();
        Cursor cursor = dba.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQuestion(cursor.getString(1));
                quest.setAnswer(cursor.getString(2));
                quest.setOptionA(cursor.getString(3));
                quest.setOptionB(cursor.getString(4));
                quest.setOptionC(cursor.getString(5));
                quest.setOptionD(cursor.getString(6));

                questionList.add(quest);

            } while (cursor.moveToNext());
        }

        cursor.close();
        dba.close();
        return questionList;
    }

    public int rowCount() {
        int row = 0;
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        row = cursor.getCount();

        cursor.close();
        return row;
    }
}