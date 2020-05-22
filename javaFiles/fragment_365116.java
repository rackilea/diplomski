public class MyDBHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "prime.db";
    public static final String TABLE_PRIME = "prime";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_PRIMENO = "primeno";
    public static final String COLUMN_DATETIME = "datetime";

    public MyDBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_PRIME + "(" +
                /* This must be in same order everywhere! */
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +    // ID will be index 0
                COLUMN_PRIMENO + " INTEGER, " +                         // Prime will be index 1
                COLUMN_DATETIME + " LONG);";                            // Date will be index 2
        db.execSQL(query);

        /* Something else to note: I changed the column types. You had text for these,
         * which is fine. But the object that you are storing in each of these is not
         * a string. So for consistency store the object as its original class type:
         * PrimeNo == integer
         * Datetime == long (milliseconds)
         * This also makes it so sorting is much easier */
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRIME);
        onCreate(db);
    }

    /**
     * You want to save the entire Prime object at once. Not bits and pieces.
     *
     * @param prime
     */
    public void addPrime(Prime prime) {
        ContentValues values = writePrime(prime);
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_PRIME, null, values);
        /* DON'T FORGET TO CLOSE YOUR DATABASE! */
        db.close();
    }

    /**
     * Again, you want to receive the entire prime object at once. Not bits.
     *
     * @return List of previous prime objects
     */
    public List<Prime> getPrimeObjects() {
        final List<Prime> primes = new ArrayList<Prime>();
        final SQLiteDatabase db = getWritableDatabase();
        /* Normally i would use this line of code:

        final Cursor c = db.rawQuery("SELECT * FROM " + TABLE_PRIME, null);

        but, you want to be sure you will get them order by DATE so you know
        the first prime in the list is the last added. so I switched the query to this:
         */

        final Cursor c = db.query(TABLE_PRIME,
                new String[]{COLUMN_ID, COLUMN_PRIMENO, COLUMN_DATETIME},
                null, null, null, null, //much null. So wow.
                COLUMN_DATETIME + " DESC"); //order in descending.

        /* After queried the first item will be our starting point */

        c.moveToFirst();
        while (c.moveToNext()) {
            Prime p = buildPrime(c);
            //check not null
            if (p != null)
                primes.add(p); //add to list
        }

        /* DON'T FORGET TO CLOSE YOUR DATABASE AND CURSOR! */
        c.close();
        db.close();
        return primes;
    }

    /**
     * Convert the Cursor object back in to a prime number
     *
     * @param cursor Cursor
     * @return Prime
     */
    private Prime buildPrime(Cursor cursor) {
        final Prime prime = new Prime();
        prime.set_id(cursor.getInt(0));             // id index as stated above
        prime.set_primeno(cursor.getInt(1));        // prime index as stated above
        prime.setDateTime(cursor.getLong(2));        // date index as stated above
        return prime;
    }

    /**
     * Convert the prime object in to ContentValues to write to DB
     *
     * @param prime prime
     * @return ContentValues
     */
    private ContentValues writePrime(Prime prime) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_PRIMENO, prime.get_primeno());    //must insert first
        values.put(COLUMN_DATETIME, prime.getDateTime());    //must insert second
        return values;
    }

}