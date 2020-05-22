String dbFile = "C:/Users/Public/test/DB.mdb";
try (Database db = DatabaseBuilder.open(new File(dbFile))) {
    Table table = db.getTable("Table1");
    Cursor cursor = CursorBuilder.createCursor(table);
    int testNum = 1;
    for (Row row : cursor.newIterable().addMatchPattern("testnum", testNum)) {
        row.put("active", true);
        table.updateRow(row);
    }
} catch (Exception e) {
    e.printStackTrace(System.out);
}