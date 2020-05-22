public UserMealUnit getusermealunit(int mealid) {
    SQLiteDatabase db = this.getReadableDatabase();

    String selectQuery = "SELECT  * FROM " + TABLE_USERMEALUNIT + " WHERE "
            + TABLE_USERMEALUNIT_ID + " = " + mealid;

    Log.d(LOG, selectQuery);

    Cursor c = db.rawQuery(selectQuery, null);

    if (c != null)
        c.moveToFirst();

    UserMealUnit mealunit = new UserMealUnit();
    mealunit.setMealid(c.getInt(c.getColumnIndex(KEY_ID)));//KEY_ID key for fetching id
    mealunit.setBreakfast((c.getInt(c.getColumnIndex(KEY_BREAKFAST))));//KEY_BREAKFAST key for fetching isBreakfast
    mealunit.setLunch((c.getInt(c.getColumnIndex(KEY_LUNCH))));//KEY_LUNCH key for fetching isLunch
    mealunit.setVegetables((c.getFloat(c.getColumnIndex(KEY_VEGETABLE))));//KEY_VEGETABLE key for fetching vegetables

    return mealunit;
}