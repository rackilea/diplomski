Cursor cursor = MainActivity.sqLiteHelper.getData("SELECT * FROM FOOD");
list.clear();
while (cursor.moveToNext()){
    int id = cursor.getInt(0);
    // int id = cursor.getInt(cursor.getColumnIndex("Id"));
    String name = cursor.getString(1);
    String price = cursor.getString(2);
    String imageUrl = cursor.getString(3);

    list.add(new Notice(id,name, price, imageUrl));
}