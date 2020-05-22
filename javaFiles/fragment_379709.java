public Cursor getStateData() {
    SQLiteDatabase db = getReadableDatabase();
    SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
    String [] sqlSelect = {"0 _id", "state", "iconone" };
    String sqlTables = "Reefs";
    qb.setTables(sqlTables);
    qb.setDistinct(true);
    Cursor c = qb.query(db, sqlSelect, null, null, null, null, null);
    c.moveToFirst();
    return c;
}