public List<Integer> getDateIds(String dateClicked) {
    List<Integer> ids = new ArrayList<>();

    String last_query = "SELECT " + COL_1  + " FROM " + TABLE_NAME  + " WHERE " + COL_4 + " = '" + dateClicked + "'";
    Cursor c = database.rawQuery(last_query, null);
    c.moveToFirst();
    while (!c.isAfterLast()) {
        ids.add(c.getInt(0));

        c.moveToNext();
    }
    c.close();
    return ids;
}