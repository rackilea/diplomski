SQLiteDatabase db = getWritableDatabase();
        Cursor shoplistcursor = getAllRowsFromTable(SHOPLIST_TABLE_NAME);
        Cursor productcsr;
        Cursor aislecsr;
        Cursor prdusecsr;
        while(shoplistcursor.moveToNext()) {
            productcsr = getProductFromProductId(shoplistcursor.getLong(shoplistcursor.getColumnIndex(SHOPLIST_COLUMN_PRODUCTREF)));
            aislecsr = getAisleFromAisleId(shoplistcursor.getLong(shoplistcursor.getColumnIndex(SHOPLIST_COLUMN_AISLEREF)));
            prdusecsr = getProductUsage(shoplistcursor.getLong(shoplistcursor.getColumnIndex(SHOPLIST_COLUMN_AISLEREF)),
                    shoplistcursor.getLong(shoplistcursor.getColumnIndex(SHOPLIST_COLUMN_PRODUCTREF)));
            if (productcsr.getCount() < 1 | aislecsr.getCount() < 1 | prdusecsr.getCount() < 1) {
                deleteShopListEntry(shoplistcursor.getLong(shoplistcursor.getColumnIndex(SHOPLIST_COLUMN_ID)));
            } 
            if(shoplistcursor.isLast()) {
                prdusecsr.close();
                aislecsr.close();
                productcsr.close();
            }
        }
        shoplistcursor.close();
        db.close();
}