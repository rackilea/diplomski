public String ifExistIn(String stationName) {

    String query = "SELECT stationName FROM review WHERE stationId='" + stationName + "' LIMIT 1";
    SQLiteDatabase database = getReadableDatabase();
    Cursor c = database.rawQuery(query, null);
    c.moveToFirst();
    return c.getString(c.getColumnIndex("stationName"));
}