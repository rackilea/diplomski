public class MyDBHandlerFaecher extends SQLiteOpenHelper{

private static final int DATABASE_VERSION = 5;
private static final String DATABASE_NAME = "faecher.db";
public static final String TABLE_FAECHER = "Faechertable";
public static final String COLUMN_ID = "_id";
public static final String COLUMN_NAME = "_faechername";
public static final String COLUMN_RAUM = "_faecherraum";
public static final String COLUMN_COLOR = "_faecherfarbe";

public MyDBHandlerFaecher(FaecherActivity context, String name, SQLiteDatabase.CursorFactory factory, int version) {
    super(context, DATABASE_NAME, factory, DATABASE_VERSION);
}

//Create the table
@Override
public void onCreate(SQLiteDatabase db) {
    String query = "CREATE TABLE " + TABLE_FAECHER + "(" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_NAME + " TEXT, " +
            COLUMN_RAUM + " TEXT, " +
            COLUMN_COLOR + " TEXT " +
            ");";
    db.execSQL(query);
}

@Override
public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS " + TABLE_FAECHER);
    onCreate(db);
}

//Add a new row to the DB
public void addFach(Faecher fach){
    ContentValues values = new ContentValues();

    values.put(COLUMN_NAME, fach.get_faechername());
    values.put(COLUMN_RAUM, fach.get_faecherraum());
    values.put(COLUMN_COLOR, fach.get_faecherfarbe());

    SQLiteDatabase db = getWritableDatabase();
    db.insert(TABLE_FAECHER, null, values);
    db.close();
}
//Delete row from DB
public void deleteFach(String name){
    SQLiteDatabase db = getWritableDatabase();
    db.execSQL("DELETE FROM " + TABLE_FAECHER + " WHERE " + COLUMN_NAME + "=" + "\"" + name + "\"" + ";");
}

public String[] databaseToStringArray() {
    String[] fromColumns = new String[]{COLUMN_NAME, COLUMN_RAUM, COLUMN_COLOR};
    SQLiteDatabase db = getWritableDatabase();
    Cursor cursor = db.rawQuery(" SELECT * FROM " + TABLE_FAECHER + " WHERE 1 ", null);
    //check if cursor is empty or not
    if (cursor != null && cursor.getCount()>0) {
        Log.d("Event", "Records do exist");
    }
    else {
        Log.d("Event", "Records do not exist");
    }

    cursor.moveToFirst();
    while (!cursor.isAfterLast()) {
        cursor.moveToNext();
    }
    db.close();
    return fromColumns;
}