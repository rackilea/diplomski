public class SampleHelper extends SQLiteOpenHelper {

    private static SampleHelper instance;
    private static Context mContext;

    public static synchronized SampleHelper getHelper(Context context) {
        if (instance == null)
             instance = new SampleHelper(context);
        return instance;
    }

    private SampleHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mContext = context;
    }
}