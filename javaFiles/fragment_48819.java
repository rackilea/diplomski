public SQLiteDatabase getSQLiteDatabase() {
    SQLiteDatabase database = getReadableDatabase();
    if(!isDatabaseCopied) {
        copyDatabase();
        isDatabaseCopied = true;
        database = getReadableDatabase();
    }

    return database;
}