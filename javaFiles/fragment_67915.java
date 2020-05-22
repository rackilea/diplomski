public class MySQL{
    private static MySQL myInstance;
    private SQLiteOpenHelper mHelper;
    private SQLiteDatabase myDatabase;
    ...

    //initialize
    public synchronized static void initialize(Context context){
        if(myInstance == null){
            myInstance = new MySQL(context);
        }
    }

    public synchronized static void createSomeEntry() {
        myInstance.myDatabase = myInstance.mHelper.getWritableDatabase();
        myInstance.myDatabase.query(...);
        ...
        myInstance.mHelper.close();
    }

    public synchronized static void getSomeEntry() {
        myInstance.myDatabase = myInstance.mHelper.getReadableDatabase();
        Cursor c = myInstance.myDatabase.query(...);
        ...//use cursor in a loop
        myInstance.mHelper.close();
    }
}