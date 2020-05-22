public class KamaDBAdapter
{
protected static final String TAG = "TAG";

private final Context mContext;
private SQLiteDatabase mDb;
private DataBaseHelper mDbHelper;

private static String ACCOUNT_TABLE = "account";
public static String ACCOUNT_EXTRADATA = "extraData";
public static String ACCOUNT_ID = "ID";
public static String ACCOUNT_ADDITIONALDATA = "additionalData";
public static String ACCOUNT_DATA = "data";

public KamaDBAdapter(Context context) 
{
    this.mContext = context;
    mDbHelper = new DataBaseHelper(mContext);
}

public KamaDBAdapter createDatabase() throws SQLException 
{
    try 
    {
        mDbHelper.createDataBase();
    } 
    catch (IOException mIOException) 
    {
        Log.e(TAG, mIOException.toString() + "  UnableToCreateDatabase");
        throw new Error("UnableToCreateDatabase");
    }
    return this;
}

public KamaDBAdapter open() throws SQLException 
{
    try 
    {
        mDbHelper.openDataBase();
        mDbHelper.close();
        mDb = mDbHelper.getReadableDatabase();
    } 
    catch (SQLException mSQLException) 
    {
        Log.e(TAG, mSQLException.toString());
        throw mSQLException;
    }
    return this;
}

public void close() 
{
    mDbHelper.close();
}

public int countAccountData() 
{
    Cursor mCoursor = mDb.query(ACCOUNT_TABLE, new String[] {}, null, null, null, null, null);
    int mReturnedCount = mCoursor.getCount();
    mCoursor.close();
    return mReturnedCount;
}

public long insertData(String mExtra, String mAdditionalData, String mData) 
{
    ContentValues initialValues = new ContentValues();
    initialValues.put(ACCOUNT_EXTRADATA, mExtra);
    initialValues.put(ACCOUNT_ADDITIONALDATA, mAdditionalData);
    initialValues.put(ACCOUNT_DATA, mData);
    return mDb.insert(ACCOUNT_TABLE, null, initialValues);
}

public boolean updateData(int mPosition, String mExtra, String mAdditionalData, String mData) 
{
    ContentValues initialValues = new ContentValues();
    initialValues.put(ACCOUNT_EXTRADATA, mExtra);
    initialValues.put(ACCOUNT_ADDITIONALDATA, mAdditionalData);
    initialValues.put(ACCOUNT_DATA, mData);
    return mDb.update(ACCOUNT_TABLE, initialValues, "ID=" + mPosition, null) > 0;
}

public String retriveData(int mPosition)
{
    Cursor mCursor = mDb.query(ACCOUNT_TABLE, new String[] {ACCOUNT_DATA}, "ID=" + mPosition, null, null, null, null);
    mCursor.moveToFirst();
    String mReturn = mCursor.getString(mCursor.getColumnIndex(ACCOUNT_DATA));
    mCursor.close();
    return mReturn;
}

public String retriveAdditionalData(int mPosition)
{
    Cursor mCursor = mDb.query(ACCOUNT_TABLE, new String[] {ACCOUNT_ADDITIONALDATA}, "ID=" + mPosition, null, null, null, null);
    mCursor.moveToFirst();
    String mReturn = mCursor.getString(mCursor.getColumnIndex(ACCOUNT_ADDITIONALDATA));
    mCursor.close();
    return mReturn;
}

public boolean deleteAccount(int mPosition) 
{
    return mDb.delete(ACCOUNT_TABLE, ACCOUNT_ID + "=" + mPosition, null) > 0;
}
}