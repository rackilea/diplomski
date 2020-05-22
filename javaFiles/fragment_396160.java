String result;
String[] cols = new String[] { "data" };
String[] args = new String[] { id };
Cursor cursor = mSqliteDb.query(MY_TABLE, cols, "_id = ?", args, null, null, null);
if (cursor.moveToNext())
    result = cursor.getString(0);
cursor.close();