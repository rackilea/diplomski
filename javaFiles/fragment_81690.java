private List<Driver> queryAllDriver() {
    List<Driver> drivers = null;

    DataBaseHelper helper = new DataBaseHelper(this);

    SQLiteDatabase db = helper.getReadableDatabase();
    if (db != null) {
        Cursor cursor = null;
        try {
            cursor = db.query(DataBaseHelper.TABLE_NAME, null, null, null, null, null, null);
            if(cursor != null && cursor.moveToFirst()) {
                do {
                    final long id = cursor.getLong(cursor.getColumnIndex(Driver._ID));
                    final String code = cursor.getString(cursor.getColumnIndex(Driver.CODE_CLOMN_NAME));
                    final String name = cursor.getString(cursor.getColumnIndex(Driver.NAME_CLOMN_Name));

                    Driver driver = new Driver();
                    driver.id = id;
                    driver.code = code;
                    driver.name = name;

                    if(drivers == null)
                        drivers = new ArrayList<DataBaseHelper.Driver>();

                    drivers.add(driver);
                } while(cursor.moveToNext());
            }
        } catch (SQLiteException e) {
            e.printStackTrace();
        } finally {
            if(cursor != null)
                cursor.close();
        }

        db.close();
    }

    return drivers;
}