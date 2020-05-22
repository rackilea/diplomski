public class ContentDatabase extends SQLiteOpenHelper {

  // Whenever you change the DB structure, increment DATABASE_VERSION (it starts from 1, so  your first upgrade should be 2)
  // - note it's only used for upgrades; if it's a new install, onUpgrade won't be called and everything is done by onCreate instead
  private static final int DATABASE_VERSION = 6;

  public ContentDatabase(Context context) {
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
  }

  public void onCreate(SQLiteDatabase db) {
    // Code to create the most recent version of your database 
    // i.e. CREATE TABLE xxx (....) 
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    // Code to update an existing database structure to the most recent 
    // version. 

    if (oldVersion < 2) {
      // do something to upgrade the DB to version 2
    }

    if (oldVersion < 3) {
      // do something to upgrade the DB to version 3
    }

    if (oldVersion < 6) {
      // Let's assume you added a new table in v4, and then added a field to that new table in v6
      if (oldVersion < 4) {
        // add the v6 version of the new table to the DB
      }
      else {
        // add the new field to the existing v4 table in the DB
      }
    }

  }
}