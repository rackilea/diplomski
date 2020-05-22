public void upDateUser(String ID, String money) {
        String query = "Select money from TABLE_NAME where ID = " + ID;
        SQLiteDatabase db = this.getWriteableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        int oldMoney = 0;
        if (cursor.moveToFirst()) {         
            oldMoney = Integer.parseInt(cursor.getString(0)); //Cause we get only from money column
        }
        ContentValues cvUpdate = new ContentValues();
        cvUpdate.put(KEY_CREDITS, oldMoney  + money);
        String filter = "UID" + "=" + ID;
        db.update(DATABASE_TABLE, cvUpdate, filter, null);
    }