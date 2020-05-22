public Cursor getRow(SQLiteDatabase sqLiteDatabase, long rowId) {
        String where = UserContract.NewUserInfo.USER_ROWID +"="+ rowId;
        Log.e("ID= ",where);

        String select = "SELECT "+ UserContract.NewUserInfo.USER_NAME+" FROM "+ UserContract.NewUserInfo.TABLE_NAME+ " WHERE "+where;
        Log.e("query = ", select);
        cursor = sqLiteDatabase.query(select);

        return cursor;
    }