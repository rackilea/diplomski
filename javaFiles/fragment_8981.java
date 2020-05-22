private static List<String> listTables(SQLiteDatabase db) {
    List<String> tableNames = new ArrayList<>();

    Cursor tableListCursor = db.rawQuery("SELECT name FROM sqlite_master WHERE type='table' AND name NOT LIKE 'android_metadata' AND name NOT LIKE 'sqlite_sequence'", null);
    while(tableListCursor.moveToNext()) {
        // get the name of the table
        tableNames.add(tableListCursor.getString(0));
    }
    tableListCursor.close();

    return tableNames;
}