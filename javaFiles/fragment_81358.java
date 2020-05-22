import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class MyDbAdapter {
    public static final String TAG = "MyDbAdapter";
    protected static final String DB_NAME = "mydb.db";
    protected static final int DB_VERSION = 21;

    private final Context context;
    private DbHelper helper;
    private SQLiteDatabase db;

    private static final String CREATE_TABLE_CRUISE_LINES = "create table " + CruiseLineAdapter.TABLE + " (" + CruiseLineAdapter.C_ID + " integer primary key autoincrement, "
            + CruiseLineAdapter.C_NAME + " TEXT);";
    private static final String CREATE_TABLE_SHIPS = "create table " + ShipAdapter.TABLE + " (" + ShipAdapter.C_ID + " integer primary key autoincrement, "
            + ShipAdapter.C_NAME + " TEXT, "
            + ShipAdapter.C_CRUISE_LINE + " integer);";
    private static final String CREATE_TABLE_TABLE_UPDATES = "create table " + UpdateTimestampAdapter.TABLE + " (" + UpdateTimestampAdapter.C_ID + " integer primary key autoincrement, "
            + UpdateTimestampAdapter.C_TABLE_NAME + " TEXT, "
            + UpdateTimestampAdapter.C_LAST_UPDATE + " TEXT);";

    private static final String DROP_TABLE = "drop table if exists %s";
    private static final String DROP_TABLE_CRUISE_LINES = String.format(DROP_TABLE, CruiseLineAdapter.TABLE);
    private static final String DROP_TABLE_SHIPS = String.format(DROP_TABLE, ShipAdapter.TABLE);
    private static final String DROP_TABLE_TABLE_UPDATES = String.format(DROP_TABLE, UpdateTimestampAdapter.TABLE);

    public MyDbAdapter (Context context) {
        this.context = context;
        helper = new DbHelper(this.context);
    }

    private static class DbHelper extends SQLiteOpenHelper {
        DbHelper (Context context) {
            super(context, DB_NAME, null, DB_VERSION);
            Log.i(TAG, "initialized");
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.i(TAG, "Database created: version " + DB_VERSION);
            db.execSQL(CREATE_TABLE_CRUISE_LINES);
            db.execSQL(CREATE_TABLE_SHIPS);
            db.execSQL(CREATE_TABLE_TABLE_UPDATES);
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.i(TAG, "Database upgraded to " + DB_VERSION);
            db.execSQL(DROP_TABLE_CRUISE_LINES);
            db.execSQL(DROP_TABLE_SHIPS);
            db.execSQL(DROP_TABLE_TABLE_UPDATES);

            this.onCreate(db);
        }
    }

    public MyDbAdapter open() throws SQLException {
        db = helper.getWritableDatabase();
        return this;
    }

    public void close() {
        helper.close();
    }
}