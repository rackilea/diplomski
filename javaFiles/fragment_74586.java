public String getName(long id) {

    String rv = "not found";
    SqliteDatabase db = this.getWritableDatabase();
    String whereclause = "ID=?";
    String[] whereargs = new String[]{String.valueOf(id)};
    Cursor csr = db.query(TABLE_NAME,null,whereclause,whereargs,null,null,null);
    if (csr.moveToFirst()) {
        rv = csr.getString(csr.getColumnIndex(COL2));
    }
    return rv;
}