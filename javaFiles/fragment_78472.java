public class MultiUserDBHelper extends SQLiteOpenHelper {

    public static final String ASSET_NAME = "mydb";
    public String DB_PATH;

    Context mContext;
    SQLiteDatabase mDataBase;

    public MultiUserDBHelper(Context context, String User) {

        super(context, User+ASSET_NAME, null, 1);
        DB_PATH = context.getDatabasePath(User+ASSET_NAME).getPath();
        this.mContext = context;
        if (!checkDataBase()) {
            copyDataBase();
        }
        mDataBase = this.getWritableDatabase(); //Forces open and therefore creation if db doesn exist.
    }


    public void copyDataBase() {
        try {
            InputStream myInput = mContext.getAssets().open(ASSET_NAME);
            String outputFileName = DB_PATH;
            OutputStream myOutput = new FileOutputStream(outputFileName);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = myInput.read(buffer)) > 0)
                myOutput.write(buffer, 0, length);

            myOutput.flush();
            myOutput.close();
            myInput.close();
            ;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error copying database from asset");
        }
    }


    public boolean checkDataBase() {
        File dbfile = new File(DB_PATH);
        if (dbfile.exists()) return true;
        if (!(dbfile.getParentFile()).exists()) dbfile.getParentFile().mkdirs();
        return false;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}