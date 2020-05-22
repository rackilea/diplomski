public class DataBaseOpenHelper extends SQLiteOpenHelper {

    private int newVersion;
    private String name;

    public DataBaseOpenHelper(Context context, String name, int version) {
        super(context, name, null, version);
        this.newVersion = version;
        this.name = name;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table if not exists "
                + DBConstants.DB_TABLE_ACCOUNTS
                + "(_id integer primary key autoincrement, account_number text not null, "
                + "account_name text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}