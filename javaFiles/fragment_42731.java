String TABLE_URUN = "urun_table";
String KEY_ID = "ID";

public Cursor getDataWithId(String id) {
  SQLiteDatabase db = this.getWritableDatabase();
  String query = String.format("SELECT * FROM %s WHERE %s = ?", TABLE_URUN, KEY_ID);
  Cursor res = db.rawQuery(query, new String[]{id});
  return res;
}