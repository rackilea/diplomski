public void deleteRow (String subject) {
    SQLiteDatabase db = this.getWritableDatabase();
    String sql = "DELETE FROM " + TABLE_NAME + " WHERE " + COL_2 + " = ?";
    SQLiteStatement statement = db.compileStatement(sql);
    statement.bindString(1, subject);

    int numRowsDeleted = statement.executeUpdateDelete();
    // you might want to check the number of records which were actually deleted
}