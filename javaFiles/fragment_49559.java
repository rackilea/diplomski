public String leagueBowlerCount(String leagueId)
{
    String rv = "0";
    SQLiteDatabase db = this.getReadableDatabase();
    Cursor cursor = db.query(Bowler.TABLE_NAME,new String[]{"count(*)"},Bowler.COLUMN_LEAGUE_ID + "=?",new String[]{leagueId},null,null,null);
    if (cursor.moveToFirst()) {
        rv = String.valueOf(cursor.getLong(0));
    }
    cursor.close();
    db.close();
    return rv;
}