public String select(String question_id) {
   SQLiteDatabase db = this.getWritableDatabase(); 
   String str_answer="";
   String sql = "SELECT answer FROM answers WHERE _id="+question_id;
   Log.i("select: ",sql);
   Cursor cursor = db.rawQuery(sql, null); //<< execute here 
   cursor.moveToFirst();
   if (cursor.getCount()>0) {
      str_answer=cursor.getString(cursor.getColumnIndex("answer");
    }
  return str_answer;
}