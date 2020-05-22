/**
 * create custom DatabaseHelper class that extends SQLiteOpenHelper
 */
public class DatabaseHelper extends SQLiteOpenHelper { 
    private static DatabaseHelper mInstance = null;

    private static final String DATABASE_NAME = "databaseName";
    private static final String DATABASE_TABLE = "tableName";
    private static final int DATABASE_VERSION = 1;

    private Context mCxt;

    public static DatabaseHelper getInstance(Context ctx) {
        /** 
         * use the application context as suggested by CommonsWare.
         * this will ensure that you dont accidentally leak an Activitys
         * context (see this article for more information: 
         * http://android-developers.blogspot.nl/2009/01/avoiding-memory-leaks.html)
         */
        if (mInstance == null) {
            mInstance = new DatabaseHelper(ctx.getApplicationContext());
        }
        return mInstance;
    }

    /**
     * constructor should be private to prevent direct instantiation.
     * make call to static factory method "getInstance()" instead.
     */
    private DatabaseHelper(Context ctx) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.mCtx = ctx;
    }
}