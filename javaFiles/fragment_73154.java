public class MySQLiteHelper extends SQLiteOpenHelper {

    private static final String FILE_NAME = "application.db";
    private static final int DB_VERSION = 1;
    private final String TAG = MySQLiteHelper.class.getCanonicalName();
    private static SQLiteDatabase database = null;

    public MySQLiteHelper(Context context) {
        super(context, FILE_NAME, null, DB_VERSION);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        //version 1
        database.execSQL(ProductsTbl.CREATE_SQL);
        //can create new tables if necessary, make sure to increase database version

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        Log.i(TAG, "Upgrading from version " + oldVersion + " to version "
                                + newVersion);
        for (int i = oldVersion + 1; i <= newVersion; i++) {
            Log.i(TAG, "version is becoming current " + i);
            switch (i) {
                case 2:
                    db.execSQL(ProductsTbl.CREATE_SQL);
                    break;
            //add more cases for each additional table added

            }
        }
    }

    public static class ProductsTbl {
        public static final String TABLE_NAME = "products";
        public static final String ID = "_id";
        public static final String URL = "url";
        public static final String TITLE = "title";
        public static final String PRICE = "price";
        public static final String[] TABLE_COLUMNS = { ID, URL, TITLE, PRICE };
        public static final String CREATE_SQL = "create table " + TABLE_NAME
                                                                                        + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                                                                                        + URL + " TEXT,"
                                                                                        + TITLE + " TEXT,"
                                                                                        + PRICE + " INTEGER);";
    }

}