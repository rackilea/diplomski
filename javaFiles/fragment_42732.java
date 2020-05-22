String KEY_OTHER = "other";

public Cursor getDataWithId(String id, String other) {
  String query = String.format("SELECT * FROM %s WHERE %s = ? AND %s = ?", TABLE_URUN, KEY_ID, KEY_OTHER);
  Cursor res = db.rawQuery(query, new String[]{id, other});
  return res;
}