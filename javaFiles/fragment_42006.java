public List<FavouritesHelper> getAllData() {
    List<FavouritesHelper> data = new ArrayList<>();

    // Select All Query
    String selectQuery = "SELECT * FROM " + FavouritesHelper.TABLE_NAME;

    SQLiteDatabase db = this.getWritableDatabase();
    Cursor cursor = db.rawQuery(selectQuery, null);

    // looping through all rows and adding to list
    if (cursor.moveToFirst()) {
        do {
            FavouritesHelper alldata = new FavouritesHelper();

            alldata.setName(cursor.getString(cursor.getColumnIndex(FavouritesHelper.Name)));
            alldata.setPhoneNumber(cursor.getString(cursor.getColumnIndex(FavouritesHelper.PhoneNumber)));
            alldata.setFavourites(cursor.getBoolean(cursor.getColumnIndex(FavouritesHelper.Favourites)));

            data.add(alldata);
        } while (cursor.moveToNext());
    }

    // close db connection
    db.close();

    // return notes list
    return data;
}