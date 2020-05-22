builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
    public void onClick(DialogInterface dialog, int ii) {

        database = dbHelper.getWritableDatabase();
        Cursor cursor = (Cursor) p.getItemAtPosition(po);

        // Get the state's capital from this row in the database.
        long ID =
                cursor.getLong(cursor.getColumnIndexOrThrow("_id"));
        sqlcon.delete(ID);

        Cursor cursor2 = sqlcon.readEntry(name1);
        dataAdapter.changeCursor(cursor2);
    }
});