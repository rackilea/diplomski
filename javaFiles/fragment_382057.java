public long getCount(String column_x_Value) {
            long count;
     SQLiteDatabase db = this.getWritableDatabase();
            Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + column_x + "='" + column_x_Value+ "'", null);
//here column_x name of column and column_x_Value which is to be counted
           count = c.getCount();
            if (c != null && !c.isClosed())
            c.close();
            return count;
        }