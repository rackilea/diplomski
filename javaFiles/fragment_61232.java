SQLiteDatabase db = myDbHelper.getReadableDatabase();
//SQLiteDatabase db = SQLiteDatabase.openDatabase("/data/data/com.example.abc2/databases/DB_BusData", null, 0);
Cursor c = db.rawQuery("SELECT * FROM Tbl_Vehicle", null);
//=====Add Additional=====
MatrixCursor extras = new MatrixCursor(new String[] { "_id", "Plat_No" });
extras.addRow(new String[] { "-1","< Select Vehicle >" });
Cursor[] cursors = { extras, c };
c = new MergeCursor(cursors);
//===========================