public class DBHelper extends SQLiteOpenHelper {

    public String databaseName;

    public DBHelper(Context context, String databaseName) {
        super(context, databaseName, null, 3);
        this.databaseName = databaseName;
    }

    // ...
}