public static List<String> GetColumns(SQLiteDatabase db, String tableName) {
    List<String> ar = null;
    Cursor c = null;
    try {
        c = db.rawQuery("select * from " + tableName + " limit 1", null);
        if (c != null) {
            ar = new ArrayList<String>(Arrays.asList(c.getColumnNames()));
        }
    } catch (Exception e) {
        Log.v(tableName, e.getMessage(), e);
        e.printStackTrace();
    } finally {
        if (c != null)
            c.close();
    }
    return ar;
}

public static String join(List<String> list, String delim) {
    StringBuilder buf = new StringBuilder();
    int num = list.size();
    for (int i = 0; i < num; i++) {
        if (i != 0)
            buf.append(delim);
        buf.append((String) list.get(i));
    }
    return buf.toString();
}