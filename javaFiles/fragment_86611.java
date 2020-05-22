public Cursor showRecordsFromExample(){
    String[] selectedColumn = new String[]{_id, KEY_EXAMPLE};
    Cursor selectedCursor = sqLiteDatabase.query(MYDATABASE_TABLE, selectedColumn,
            KEY_EXAMPLE + " LIKE '%a%'", null, null,
            null, null);
}