public int maxFromName(String name){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT " + COLUMN_MAX + " FROM "+ TABLE_AZKAR+" WHERE " +COLUMN_NAME+ "= '" + name +"'" ;
        Cursor c = db.rawQuery(query, null);
        if(c.getCount()!=0){
            c.moveToFirst();
            return c.getInt(c.getColumnIndex("MaxNum"))
          }
    return 0;
}