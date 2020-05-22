public boolean isDataAvailable(String title) {
        SQLiteDatabase db = this.getWritableDatabase();

        boolean isAvailable = false;

        try {
            Cursor cursor;
            String sql = "SELECT * FROM " + TABLE_NAME + " WHERE fav_id =" + id; // you can check it by comparing any unique value 
            cursor = db.rawQuery(sql, null);
            isAvailable = cursor.getCount() > 0;
            cursor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return isAvailable;
    }