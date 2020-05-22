public void cleanCart() { // remove parameter
    SQLiteDatabase db = getReadableDatabase();
    String query = String.format("DELETE FROM OrderDetail");

    db.execSQL(query);
}