public class MySQLiteDatasource {

    //Database fields
    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;

    public MySQLiteDatasource(Context context) {
        dbHelper = new MySQLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public void insertProduct(String url, String title, String price) {
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.ProductsTbl.URL, url);
        values.put(MySQLiteHelper.ProductsTbl.TITLE, title);
        values.put(MySQLiteHelper.ProductsTbl.PRICE, price);

        try {
            database.insertOrThrow(MySQLiteHelper.ProductsTbl.TABLE_NAME, null, values);
        } catch (SQLiteConstraintException e) {
            //System.out.println(e);
            Log.e("SQLite Database", "Unable to INSERT into Database, possible duplicate topic already exists.");
        }
    }

}