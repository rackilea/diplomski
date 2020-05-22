public void updateAccount( AccountObject inAccountObj){

    ContentValues values = new ContentValues();
    values.put(COL_NAME, inAccountObj.getName() );
    values.put(COL_USER, inAccountObj.getUser() );
    values.put(COL_PW, inAccountObj.getPassword() );
    values.put(COL_NOTES, inAccountObj.getNotes() );

    String whereClause = KEY_ROWID + " = ? ";
    String[] whereArgs = new String[] { inAccountObj.getRowId().toString() };

    mDb.update(TABLE_ACCOUNT, values, whereClause, whereArgs);

}