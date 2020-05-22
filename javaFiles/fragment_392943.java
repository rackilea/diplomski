public class DBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "NOTES";
    public static final String USER_COLUMN_ID = "idu";
    public static final String TABLE_USER_NAME = "name";
    public static final String USER_COLUMN_NAME = TABLE_USER_NAME;

    public static final String CREATE_TABLE_USER =
            "CREATE TABLE " + TABLE_USER_NAME + "("
                    + USER_COLUMN_ID + " INTEGER PRIMARY KEY,"
                    + USER_COLUMN_NAME + " TEXT UNIQUE "
                    + ")";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Notes.CREATE_TABLE_NOTE);
        db.execSQL(CREATE_TABLE_USER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Notes.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER_NAME);
        onCreate(db);
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.setForeignKeyConstraintsEnabled(true);
    }

    public long insertUser(String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(USER_COLUMN_NAME,username);
        return db.insert(TABLE_USER_NAME,null,cv);
    }

    public long insertNote(String note, long usermap) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Notes.COLUMN_NOTE, note);
        values.put(Notes.NOTE_COLUMN_USERMAP,usermap);
        long id = db.insert(Notes.TABLE_NAME, null, values);
        db.close();
        return id;
    }

    public Notes getNote(long id) {

        Notes notes = null;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(Notes.TABLE_NAME,
                new String[]{Notes.NOTE_COLUMN_ID, Notes.COLUMN_NOTE, Notes.NOTE_COLUMN_USERMAP},
                Notes.NOTE_COLUMN_ID + "=?",
                new String[]{String.valueOf(id)},
                null, null, null, null
        );
        if (cursor.moveToFirst()) {
            notes = new Notes(
                    cursor.getInt(cursor.getColumnIndex(Notes.NOTE_COLUMN_ID)),
                    cursor.getString(cursor.getColumnIndex(Notes.COLUMN_NOTE)),
                    cursor.getLong(cursor.getColumnIndex(Notes.NOTE_COLUMN_USERMAP))
            );
        }
        cursor.close();
        return notes;
    }

    public List<Notes> getAllNotes() {
        List<Notes> notes = new ArrayList<>();

        String selectQuery = "SELECT  * FROM " + Notes.TABLE_NAME + " ORDER BY " +
                Notes.NOTE_COLUMN_ID + " DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        while (cursor.moveToNext()) {
            Notes note = new Notes();
            note.setId(cursor.getInt(cursor.getColumnIndex(Notes.NOTE_COLUMN_ID)));
            note.setNote(cursor.getString(cursor.getColumnIndex(Notes.COLUMN_NOTE)));
            note.setUsermap(cursor.getLong(cursor.getColumnIndex(Notes.NOTE_COLUMN_USERMAP)));
            notes.add(note);
        }
        db.close();
        return notes;
    }

    public List<Notes> getNotesByUser(long usermap) {

        List<Notes> notes = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(Notes.TABLE_NAME,
                new String[]{Notes.NOTE_COLUMN_ID, Notes.COLUMN_NOTE,Notes.NOTE_COLUMN_USERMAP},
                Notes.NOTE_COLUMN_USERMAP + "=?",
                new String[]{String.valueOf(usermap)}, null, null, null, null);
        while(cursor.moveToNext()) {
            notes.add(new Notes(cursor.getInt(cursor.getColumnIndex(Notes.NOTE_COLUMN_ID)),
                    cursor.getString(cursor.getColumnIndex(Notes.COLUMN_NOTE)),
                    cursor.getLong(cursor.getColumnIndex(Notes.NOTE_COLUMN_USERMAP)))
            );
        }
        cursor.close();
        return notes;
    }

    public int getNotesCount() {
        String countQuery = "SELECT  * FROM " + Notes.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }
}