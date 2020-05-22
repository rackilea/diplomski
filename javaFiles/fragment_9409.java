if (cursor.moveToFirst()) {
    do {
       HashMap<String, Object> map1 = new HashMap<String, Object>();
        map1.put("one", cursor.getLong(cursor.getColumnIndex(DBHelper.COLUMN_ID)));
        map1.put("two", cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_DESCRIPTION)));
        map1.put("three", cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_PRICE)));
        listoff.add(map1);
    } while (cursor.moveToNext());
}