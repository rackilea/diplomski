import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBOpenHelper extends SQLiteOpenHelper {

    private enum OpenHelperEnum {
        INSTANCE; // Singleton instance;

        // Instance of dbHelper for all DB access in threads
        private SQLiteOpenHelper dbHelper = null;
        private SQLiteDatabase database = null;

        public SQLiteDatabase getDB(final Context context) {
            if (dbHelper == null) {
                dbHelper = new DBOpenHelper(context);
            }
            if (database == null) {
                database = dbHelper.getReadableDatabase();
            }
            return database;
        }
    }

    public DBOpenHelper(final Context context) {
        super(context, "DBName", null, 1);
    }

    @Override
    public void onCreate(final SQLiteDatabase database) {
        // ...
    }

    @Override
    public void onUpgrade(final SQLiteDatabase database, final int oldVersion, final int newVersion) {
        // ...
    }

    @Override
    public void onDowngrade(final SQLiteDatabase database, final int oldVersion, final int newVersion) {
        // ...
    }

    public static SQLiteDatabase getDB(final Context context) {
        return DBOpenHelper.OpenHelperEnum.INSTANCE.getDB(context);
    }
}