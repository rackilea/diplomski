private List<Information> getAllItems()
    List<Information> itemsList = new ArrayList<Information>();
    Cursor cursor = null;
    try {
        //get all rows
        cursor = mDatabase.query(TABLE_Name, null, null, null, null,
                null, null);
        if (cursor.moveToFirst()) {
            do {
                Information c = new Information();
                c.setName(cursor.getString(KEY_NAME));
                itemsList.add(c);
            } while (cursor.moveToNext());
        }
    } catch (SQLiteException e) {
        e.printStackTrace();
    } finally {
        cursor.close();
    }
    return itemsList;
}