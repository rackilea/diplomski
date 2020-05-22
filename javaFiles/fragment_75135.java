// test data
ArrayList<Integer> enabledComponentsIds = new ArrayList<>();
enabledComponentsIds.add(2);
enabledComponentsIds.add(3);

String dbFileSpec = "C:/Users/Public/jackcessTest.mdb";
try (Database db = DatabaseBuilder.open(new File(dbFileSpec))) {
    Table t = db.getTable("t_object");
    for (int id : enabledComponentsIds) {
        Row r = CursorBuilder.findRowByPrimaryKey(t, id);
        if (r != null) {
            t.deleteRow(r);
        }
    }
} catch (Exception e) {
    e.printStackTrace(System.err);
}