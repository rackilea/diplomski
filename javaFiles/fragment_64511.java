@Override
public void onOpen(SQLiteDatabase db) {
    super.onOpen(db);
    if (!db.isReadOnly()) {
        // Enable foreign key constraints
        db.execSQL("PRAGMA foreign_keys=ON;");
    }
}