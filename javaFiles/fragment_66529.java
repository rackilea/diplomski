SQLiteDatabase db = this.getWritableDatabase();
    final ProductFetchListener mListener = listener;
    Cursor cursor = db.rawQuery(Constants.ClientsDATABASE.GET_PRODUCTS_QUERY,null);
    final List<Clients_POJO> productsListDB = new ArrayList<>();
    if (cursor.getCount() > 0) {
        if (cursor.moveToFirst()) {
            do {
                Clients_POJO products = new Clients_POJO();
                products.setFromDatabase(true);