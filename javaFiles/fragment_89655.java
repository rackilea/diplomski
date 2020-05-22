public class ExampleSQLiteOpenHelper extends SQLiteOpenHelper {

    public ExampleSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // The create query here always has to be for the most up to 
        // date version of the database
        db.execSQL("CREATE TABLE MailingList (Email VARCHAR, Name VARCHAR, PhoneNumber VARCHAR);");
        db.execSQL("CREATE TABLE SomeTable (_id PRIMARY KEY AUTOINCREMENT, SomeColumn VARCHAR)");
        ...
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // This will be called when you are starting your app for the first time 
        // after increasing the version number.

        // This loops through all the version between the current version of             
        // the database and the newest version. upgradeTo is called with each 
        // version in between.
        for(int i = oldVersion + 1; i <= newVersion; i++) {
            upgradeTo(db, i);
        }
    }

    private void upgradeTo(SQLiteDatabase db, int version) {

        // With this switch you can execute the upgrade scripts for each version 
        // of the databse
        switch (version) {
            case 2:
                // in this version we added a new column to MailingList so we 
                // use ALTER TABLE to add the new column
                db.execSQL("ALTER TABLE MailingList ADD COLUMN PhoneNumber VARCHAR");
                break;

            case 3:
                // In this version we added a new table
                db.execSQL("CREATE TABLE SomeTable (_id PRIMARY KEY AUTOINCREMENT, SomeColumn VARCHAR)");
                break;

            case 4:
                ...
                break;

            case 5:
                ...
                break;
        }
    }
}