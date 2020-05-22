Map<String, String> testData = new Hashtable<String, String>();

String dbFile = "C:/Users/Public/test/DB.mdb";
try (Database db = DatabaseBuilder.open(new File(dbFile))) {
    Table table = db.getTable("db_data");
    Cursor cursor = CursorBuilder.createCursor(table);
    int testCaseId = 1;
    for (Row row : cursor.newIterable().addMatchPattern("TestCaseId", testCaseId)) {
        testData.put(row.get("Key").toString(), row.get("Data").toString());
    }

    Iterator<Map.Entry<String, String>> it = testData.entrySet().iterator();
    while (it.hasNext()) {
        Map.Entry<String, String> entry = it.next();
        System.out.println(String.format(
                "Key: %s, Data: %s", 
                entry.getKey(), 
                entry.getValue()));
    }
} catch (Exception e) {
    e.printStackTrace(System.out);
}