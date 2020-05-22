@Override
public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    updateDatabase(db, oldVersion + 1, newVersion);
}

private void updateDatabase(SQLiteDatabase db, int fromVersion, int toVersion) {
    Log.i("Updating database from version " + fromVersion + " to " + toVersion);

    for (int ver = fromVersion; ver <= toVersion; ver++) {
        switch (ver) {
            case 1:
                handleDatabaseVersion1(db);
                break;
            case 2:
                handleDatabaseVersion2(db);
                break;                  
        }
    }
}

private void handleDatabaseVersion1(SQLiteDatabase db) {
   // create initial tables and so on
}

private void handleDatabaseVersion2(SQLiteDatabase db) {
   // here we extend the Users table with another two columns
}