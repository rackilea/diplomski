public Cursor getTopTen() {

    String ids = "2, 3, 15, 23, 35, 50, 51, 60, 61, 64";

    SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
    queryBuilder.setTables(DATABASE_TABLE);

    String[] columns = new String[] { KEY_ROWID, RECIPE, DESC, PREPTIME,
            COOKTIME, SERVES, CALORIES, FAT, CATEGORY, FAV };

    Cursor myCursor = queryBuilder.query(myDataBase, columns, KEY_ROWID + " IN ("
            + ids + ")", null, null, null, null);

    return myCursor;
}