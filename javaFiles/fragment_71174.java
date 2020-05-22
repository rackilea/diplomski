public boolean userExistance(String emailOrPhone, String pwd, ParentModel parentModel)
{
  String sql = "select * from " + TABLE_NAME + " where (" + COL_3 + " = '" + emailOrPhone + "' OR " + COL_4 + " = '" + emailOrPhone + "') AND " + COL_5 + " = " + pwd;
  SQLiteDatabase mydb = this.getWritableDatabase();
  Cursor cursor = mydb.rawQuery(sql, null);
  ArrayList<ParentModel> list = new ArrayList<>();
  if (cursor.getCount() > 0) {
    if (cursor.moveToFirst()) {
        do {
            parentModel.setID(cursor.getString(0));
            parentModel.setName(cursor.getString(1));
            parentModel.setSurname(cursor.getString(2));
            parentModel.setEmail(cursor.getString(3));
            parentModel.setPhone_number(cursor.getString(4));
            parentModel.setPassword(cursor.getString(5));
            list.add(parentModel);
        }
        while (cursor.moveToNext());
    }
    return true;
}
 return false;