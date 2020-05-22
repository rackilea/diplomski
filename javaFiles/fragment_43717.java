...
do {
    map1 = newHashMap<String, String>(); // add
    productmoduledesc=cursor.getString(cursor.getColumnIndex(DBHelper.PRODUCT_MODULE_DESC));
    producttype = cursor.getString(cursor.getColumnIndex(DBHelper.PRODUCT_TYPE));
    productpromo = cursor.getString(cursor.getColumnIndex(DBHelper.PRODUCT_PROMOTION));
    map1.put("one",productmoduledesc);
    map1.put("two",producttype);
    map1.put("three",productpromo);
    promo.add(map1);    
  } while (cursor.moveToNext());
...