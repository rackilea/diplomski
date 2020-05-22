public static Cursor getSuggestions(String query) {
    SQLiteDatabase db = dbHelper.getReadableDatabase();
    String selection = Formula.FORMULA_NAME + " LIKE %?%";
    String[] selectionArgs = { query + "*" };
    Cursor cursor = db.query(
            FORMULA_TABLE_NAME,
            new String[] { BaseColumns._ID,
                    SearchManager.SUGGEST_COLUMN_TEXT_1, 
                    BaseColumns._ID + " AS " + SearchManager.SUGGEST_COLUMN_INTENT_DATA_ID 
                    }, 
            selection,
            selectionArgs, null, null, null);
    return cursor;
}