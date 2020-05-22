import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by shellstrom on 2017-05-29.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "db";
    public static final String CREATE_ITEMS_TABLE = "CREATE TABLE items (_ID INTEGER PRIMARY KEY, code INTEGER, item TEXT, description TEXT)";
    private static final String put = "INSERT INTO items (code,item,description) values ('','1', 'obj', 'obj info')";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_ITEMS_TABLE);
        db.execSQL(put);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        android.util.Log.w("Constants", "Upgrading database, which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS items");
        onCreate(db);
    }
}