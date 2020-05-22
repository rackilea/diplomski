public class DatabaseHelper extends SQLiteOpenHelper {
    DatabaseHelper dh;

    private static final int DATABASE_VERSION = 1; 
    private static final String DB_NAME = "test3"; 
    private static final String DB_PATH = "/data/data/com.example.test/databases/";
    private static final String TABLE = "HighscoresList"; 

    // Table columns names. 
    private static final String RANK = "_id"; 
    private static final String SCORE = "score"; 
    private static final String PERCENTAGE = "percentage";

    public DatabaseHelper(Context context) { 
        super(context, DB_NAME, null, DATABASE_VERSION);
    }

    public SQLiteDatabase openDb() {
      return this.getReadableDatabase(); // Use Readable because you're not actually writing any values into your db
    }

    public void closeDb(SQLiteDatabase db) {
      db.close();
    }

    public Cursor getScore(SQLiteDatabase db) {
      return db.rawQuery("SELECT " + SCORE + " FROM " + TABLE + ";", null);
    }

    public Cursor getPercentage(SQLiteDatabase db) {
      return db.rawQuery("SELECT " + PERCENTAGE + " FROM " + TABLE + ";", null);
    }
}