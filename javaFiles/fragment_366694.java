public class ChatData extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "MessagePlus";
    public static final String TABLE_CHAT_DATA = "chatdata";
    public static final String COL_CHATDATA_ID = BaseColumns._ID;
    public static final String COL_CHATDATA_TIMESTAMP = "timestamp";
    public static final String COL_CHATDATA_MESSAGE = "message";
    public static final String COL_CHATDATA_USER = "user";

    public ChatData(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        String crt_sql = "CREATE TABLE IF NOT EXISTS " + TABLE_CHAT_DATA + "(" +
                COL_CHATDATA_ID + " INTEGER PRIMARY KEY, " +
                COL_CHATDATA_TIMESTAMP + " TEXT DEFAULT CURRENT_TIMESTAMP," +
                COL_CHATDATA_MESSAGE + " TEXT, " +
                COL_CHATDATA_USER + " INTEGER" +
                ")";
        db.execSQL(crt_sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public Cursor getAllQuestions3() {
        return this.getWritableDatabase().query(TABLE_CHAT_DATA,null,null,null,null,null,null);
    }

    public long addMessage(String message, long user) {
        ContentValues cv = new ContentValues();
        cv.put(COL_CHATDATA_MESSAGE,message);
        cv.put(COL_CHATDATA_USER,user);
        SQLiteDatabase db = this.getWritableDatabase();
        return db.insert(TABLE_CHAT_DATA,null,cv);
    }
}