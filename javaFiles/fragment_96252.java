public void populateDrinkersLijst() {

    Cursor data = mDatabaseHelper.getDrinkers();

    ArrayList<String> listData = new ArrayList<>();
    listData.add("test");

    // Check weather cursor is empty
    if(data.moveToFirst())
    {
        do
        {
            listData.add(data.getString(1));

        }while(data.moveToNext());
    }

    // Close cursor  
    data.close();

    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listData);
    mListView.setAdapter(adapter);
}