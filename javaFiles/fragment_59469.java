Cursor goodsCursor = goodsfletcher.fetchAllGoods();
String goods[] = new String[goodsCursor.getCount()] ;
TableLayout tl = (TableLayout) findViewById(R.id.baskettable);
if (c.moveToFirst()){
    do {
        String Goodname = goodsCursor.getString(1).toString() ;
    }while (c.moveToNext());


}

c.close();