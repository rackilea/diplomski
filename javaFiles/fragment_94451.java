public void grabTables() {
    Cursor cur = this.db.rawQuery("SELECT * FROM sqlite_master where name like 'List_%'", new String[0]);
    cur.moveToFirst();
    String tableName;

    while (cur.getPosition() < cur.getCount()) {
        tableName = cur.getString(cur.getColumnIndex("name"));
        System.out.println("Table Name = " + tableName);
        cur.moveToNext();
    }
    cur.close();
}