public void addProducts(Clients_POJO products) {
    //CRUD , adding Products
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues values = new ContentValues();
    values.put(Constants.ClientsDATABASE.INPUT_DEPARTMENTS, String.valueOf(products.getDepartments()));
    try {

        db.insert(Constants.ClientsDATABASE.TABLE_NAME, null, values);
    } catch (Exception e) {
        Log.d(TAG, e.getMessage());
    }