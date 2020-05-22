public class DataBaseHelper extends SQLiteOpenHelper
{
private static String TAG = "TAG";
private static String DB_PATH = "/data/data/YOUR_PACKAGE/databases/";
private static String DB_NAME = "ServiceInfo.sqlite";
private SQLiteDatabase mDataBase; 
private final Context mContext;

public DataBaseHelper(Context context) 
{
    super(context, DB_NAME, null, 1);
    DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
    this.mContext = context;
}   

public void createDataBase() throws IOException
{
    boolean mDataBaseExist = checkDataBase();
    if(!mDataBaseExist)
    {
        this.getReadableDatabase();
        try 
        {
            copyDataBase();
        } 
        catch (IOException mIOException) 
        {
            throw new Error("ErrorCopyingDataBase");
        }
    }
}

private boolean checkDataBase()
{
    SQLiteDatabase mCheckDataBase = null;
    try
    {
        String myPath = DB_PATH + DB_NAME;
        mCheckDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
    }
    catch(SQLiteException mSQLiteException)
    {
        Log.e(TAG, "DatabaseNotFound " + mSQLiteException.toString());
    }

    if(mCheckDataBase != null)
    {
        mCheckDataBase.close();
    }
    return mCheckDataBase != null;
}

private void copyDataBase() throws IOException
{
    InputStream mInput = mContext.getAssets().open(DB_NAME);
    String outFileName = DB_PATH + DB_NAME;
    OutputStream mOutput = new FileOutputStream(outFileName);
    byte[] mBuffer = new byte[1024];
    int mLength;
    while ((mLength = mInput.read(mBuffer))>0)
    {
        mOutput.write(mBuffer, 0, mLength);
    }
    mOutput.flush();
    mOutput.close();
    mInput.close();
}

public boolean openDataBase() throws SQLException
{
    String mPath = DB_PATH + DB_NAME;
    mDataBase = SQLiteDatabase.openDatabase(mPath, null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
    return mDataBase != null;
}

@Override
public synchronized void close() 
{
    if(mDataBase != null)
        mDataBase.close();
    super.close();
}

@Override
public void onCreate(SQLiteDatabase db) 
{ }

@Override
public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) 
{
    Log.v(TAG, "UpgradingDatabase, This will drop current database and will recreate it");
}
}