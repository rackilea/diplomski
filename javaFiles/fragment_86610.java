public Cursor showRecordsFromExample(){
    String[] selectedColumn = new String[]{_id, KEY_EXAMPLE};
    Cursor selectedCursor = sqLiteDatabase.query(MYDATABASE_TABLE, selectedColumn,
            null, null, null,
            null, null);
    return selectedCursor;
}