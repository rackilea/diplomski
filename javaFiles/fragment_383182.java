public void upDateUser(int money) 
{
    String selectQuery = "SELECT " + KEY_CREDITS + " from " + 
                              DATABASE_TABLE + " where " + KEY_ROWID + " = " + 1;
    Cursor c = ourDatabase.rawQuery(selectQuery, null);
    int oldMoney = 0;
    Log.d("com.example.yourapp", c.getCount() + " rows selected");
    if (c.moveToFirst()) 
    {                      
         oldMoney = c.getInt(c.getColumnIndex(KEY_CREDITS));
    }
    ContentValues cvUpdate = new ContentValues();
    cvUpdate.put(KEY_CREDITS, (oldMoney + money));
    ourDatabase.update(DATABASE_TABLE, cvUpdate, KEY_ROWID + "=?" ,new String[] { "1" });
}