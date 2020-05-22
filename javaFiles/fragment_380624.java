public List<String> getAllSetcardCategory()
    {
        List<String> setcardCategories = new ArrayList<String>();
        String selectQuery = "SELECT  * FROM " + TABLE_SETCARD_CATEGORIES;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                // adding to tags list
                setcardCategories.add(c.getString(c.getColumnIndex("name")));
            } while (c.moveToNext());
        }
        return setcardCategories;
    }