SQLiteDatabase db = openOrCreateDatabase("your db file name",
            SQLiteDatabase.CREATE_IF_NECESSARY, null);
Cursor cursor = db.query("sqlite_master", new String[] { "name" },
                "name=" + "'your table name'", null, null, null, null);
if (cursor.getCount() <= 0) {
   //Table is not exists
}
else 
{
   //table is exists
}