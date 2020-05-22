public class TestDb extends AndroidTestCase {

Context mContext;
public void TestDb (Context mContext){
 this.mContext = mContext;
} 
public static final String LOG_TAG = TestDb.class.getSimpleName();

public void testCreateDb() throws Throwable {
    mContext.deleteDatabase(WeatherDbHelper.DATABASE_NAME);
    SQLiteDatabase db = new WeatherDbHelper(
            this.mContext).getWritableDatabase();
    assertEquals(true, db.isOpen());
    db.close();
}