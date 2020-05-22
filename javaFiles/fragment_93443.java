public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "mydatabase";
    public static final int DBVERSION = 1;

    public static final String TBSTORE = "store";
    public static final String TBRECIPEE = "recipee";

    private static final String store_crt = "CREATE TABLE IF NOT EXISTS " +
            TBSTORE + "(" +
            BaseColumns._ID + " INTEGER PRIMARY KEY, " +
            StoreEntry.COLUMN_PRODUCT_NAME + " TEXT, " +
            StoreEntry.COLUMN_PRODUCT_PRICE + " REAL, " +
            StoreEntry.COLUMN_PRODUCT_QUANTITY + " INTEGER, " +
            StoreEntry.COLUMN_PRODUCT_WEIGHT + " INTEGER, " +
            StoreEntry.COLUMN_SUPPLIER_NAME + " TEXT, " +
            StoreEntry.COLUMN_SUPPLIER_NUMBER + " INTEGER" +
            ")";

    private static final String recipee_crt = "CREATE TABLE IF NOT EXISTS " +
            TBRECIPEE + "(" +
            BaseColumns._ID + " INTEGER PRIMARY KEY, " +
            RecipeeEntry.COLUMN_RECIPEE_NAME + " TEXT, " +
            RecipeeEntry.COLUMN_RECIPEE_TYPE + " TEXT, " +
            RecipeeEntry.COLUMN_RECIPEE_SERVINGS + " INTEGER, " +
            RecipeeEntry.COLUMN_RECIPEE_VALUES + " TEXT " +
            ")";

    SQLiteDatabase mDB;


    public DBHelper(Context context) {
        super(context, DBNAME, null, DBVERSION);
        mDB = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(store_crt);
        db.execSQL(recipee_crt);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public long addStore(String product_name,
                         Float product_price,
                         int product_quantity,
                         int product_weight,
                         String supplier_name,
                         int supplier_number) {

        ContentValues cv = new ContentValues();
        cv.put(StoreEntry.COLUMN_PRODUCT_NAME,product_name);
        cv.put(StoreEntry.COLUMN_PRODUCT_PRICE,product_price);
        cv.put(StoreEntry.COLUMN_PRODUCT_QUANTITY,product_quantity);
        cv.put(StoreEntry.COLUMN_PRODUCT_WEIGHT,product_weight);
        cv.put(StoreEntry.COLUMN_SUPPLIER_NAME,supplier_name);
        cv.put(StoreEntry.COLUMN_SUPPLIER_NUMBER,supplier_number);
        return mDB.insert(TBSTORE,null,cv);
    }

    public Cursor getStoreEntries() {
        return mDB.query(TBSTORE,null,null,null,null,null,null);
    }

    public long addRecipee(String recipee_name, String recipee_type,int recipee_servings, String recipee_values) {
        ContentValues cv = new ContentValues();
        cv.put(RecipeeEntry.COLUMN_RECIPEE_NAME, recipee_name);
        cv.put(RecipeeEntry.COLUMN_RECIPEE_TYPE,recipee_type);
        cv.put(RecipeeEntry.COLUMN_RECIPEE_SERVINGS,recipee_servings);
        cv.put(RecipeeEntry.COLUMN_RECIPEE_VALUES,recipee_values);
        return mDB.insert(TBRECIPEE,null,cv);
    }

    public Cursor getRecipeeEntries() {
        return mDB.query(TBRECIPEE,null,null,null,null,null,null);
    }
}