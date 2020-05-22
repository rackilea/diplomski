public static class Referee
{
    private String name;
    private String game1;
    private String game2;

    public Referee(String name, String game1, String game2)
    {
        this.name = name;
        this.game1 = game1;
        this.game2 = game2;
    }

    // Getters...
}

public static Referee getReferee(String referee_id, SQLiteDatabase sqLiteDatabase)
{
    Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM tbl_referee", null);
    String refereeInfo = null;
    if (cursor != null)
    {
        if (cursor.moveToFirst())
        {
            do
            {
                String nameInRecord = cursor.getString(1);

                if (nameInRecord.equals(referee_id))
                {
                    String referee_name = cursor.getString(0);  // 0 means table column of REFEREE NAME
                    String referee_game1 = cursor.getString(2); // 2 means table column of REFEREE GAME 1
                    String referee_game2 = cursor.getString(3); // 3 means table column of REFEREE GAME 2
                    return new Referee(referee_name, referee_game1, referee_game2);
                }
            } while (cursor.moveToNext());
        }
    }
    return null;
}