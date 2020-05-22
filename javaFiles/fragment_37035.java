private void getDataAndPopulate() {

    image = new ArrayList<byte[]>();
    caption = new ArrayList<String>();

    cursor=db.rawQuery("select * from NAME",null);


    while (cursor.moveToNext()) {

        byte[] temp_image = cursor.getBlob(2);
        String temp_caption = cursor.getString(1);
        String temp_id= cursor.getString(0);
        image.add(temp_image);
        caption.add(temp_caption);
        id.add(temp_id);
    }
    String[] captionArray = (String[]) caption.toArray(
            new String[caption.size()]);

    ItemsAdapter itemsAdapter = new ItemsAdapter(Item_show_grid.this, R.layout.item_grid,captionArray);
    gv.setAdapter(itemsAdapter);

}