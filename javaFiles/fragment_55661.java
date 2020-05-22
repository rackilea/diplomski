public Cursor getRow(long rowId) {
        String where = UserContract.NewUserInfo.USER_ROWID +"="+ rowId;
        Log.e("ID= ",where);

        String select = "SELECT "+ UserContract.NewUserInfo.USER_NAME+" FROM "+ UserContract.NewUserInfo.TABLE_NAME+ " WHERE "+where;
        Log.e("query = ", select);

        // Here db is null.
        db.execSQL(select);

        return null;
    }