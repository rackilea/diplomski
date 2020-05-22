public String getW_4(){
  SQLiteDatabase db = this.getReadableDatabase();
  Cursor res =  db.rawQuery( "select * from mega", null );
  if (res.moveToFirst()) {
   return res.getString(0);
  } else {
   return "";
  }
}