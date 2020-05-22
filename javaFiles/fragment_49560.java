public String leagueBowlerCount(String leagueId)
    {

    SQLiteDatabase db = this.getReadableDatabase();
    String countQuery = "SELECT * FROM " + Bowler.TABLE_NAME + " WHERE " + Bowler.COLUMN_LEAGUE_ID + " = '" + leagueId + "'";
    Cursor cursor = db.rawQuery(countQuery, null);

    int count = cursor.getCount();
    cursor.close();
    db.close();
    return String.valueOf(count);
}