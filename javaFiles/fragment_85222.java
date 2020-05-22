public ArrayList<String> getStrings() {

  ArrayList<String> strings = new ArrayList<String>();
  String query = String.format("SELECT * FROM notes");
  Cursor c = db.getReadableDatabase().rawQuery(query, null);

  if (c.moveToFirst())
            do {
                strings.add(sessionCursor.getString(1)); // 1 = columnindex
            } while (sessionCursor.moveToNext());   

  return strings;

}