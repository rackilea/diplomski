:

class DBHelper extends SQLiteOpenHelper {

    :
    :

    private SQLiteDatabase db;
    private static final int DATABASE_VERSION = 1;
    private static final String DB_NAME = "dbname.db";
    :
    :

}

public class DBAccess {

    :
    :

    private DBHelper dbHelper;
    private SQLiteDatabase db;

    :
    :

    public DBAccess(Context context) {
        dbHelper = new DBHelper(context);
    }

    /**
     * Open the database
     */
    public void openDB() {
        db = dbHelper.getWritableDatabase();
    }

    /**
     * Close the database
     */
    public void closeDB() {
        db.close();
    }

    :
    :
}