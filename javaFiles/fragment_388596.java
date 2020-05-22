Cursor cursor = dataBase.select("SELECT * FROM " + TABLE_NAME_PRODUCTS);
while (cursor.moveToNext()){
    TableRow tr = new TableRow(this);
    //set width and height using layout params
    tl.addView(tr);
}