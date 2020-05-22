// open existing database
Database db = DatabaseBuilder.open(new File(
        "C:/Users/Gord/Desktop/foo.accdb"));

String tempTableName = "TemporaryNameForTable";

// import CSV file into new table with temporary name
ImportUtil.Builder ib = new ImportUtil.Builder(db);
ib.setTableName(tempTableName);
ib.importFile(new File("C:/Users/Gord/Desktop/foo.csv"));

// rename the new table
Table mso = db.getSystemTable("MSysObjects");
Row r = CursorBuilder.findRow(mso,
        Collections.singletonMap("Name", tempTableName));
r.put("Name", "type");  // new name is "type"
mso.updateRow(r);
db.close();