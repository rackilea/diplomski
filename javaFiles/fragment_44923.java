public String getLastDateTime() {
        String selectQuery = "SELECT * FROM " + MYTABLE + " ORDER BY datetimecolumn DESC LIMIT 1";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        String str = "0";
        if (cursor.moveToFirst())
            str = cursor.getString(cursor.getColumnIndex(KEY_COLUMN_DATETIME));
        cursor.close();

        return str;
    }