public Cursor  getUserLogedIn(String Sql,SQLiteDatabase db){

   Cursor mCursor =db.rawQuery(sql)

   return mCursor;
}