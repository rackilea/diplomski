public void populateLisView() {
    mDataBaseHelper = new DataBaseHelper(this);  //<<<<<<<<<< NOTE 1
    list = (ListView) this.findViewById(R.id.myListId); //<<<<<<<<<< NOTE 1
    data = mDataBaseHelper.getData(); //<<<<<<<<<< get the data to be listed

    if (listadapter == null) { //<<<<<<<<<< Only need to instantiate one adapter when it has not bee instantiated
        listadapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,android.R.id.text1,data); // for convenience using a stock layout
        list.setAdapter(listadapter);
        //<<<<<<<<<<< add the onItemLongClick listener
        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                mDataBaseHelper.deleteTaskByCol2(data.get(position)); //<<<<<<<<<< gets the value of the item according to it's position in the list
                populateLisView(); //<<<<<<<<<< as the item has been deleted then refresh the Listview
                return true; // flag the event as having been handled.
            }
        });
    //<<<<<<<<<<< If the Adapter has been instantiated then refresh the ListView's data
    } else {
        listadapter.clear(); // Clear the data from the adapter
        listadapter.addAll(data); // add the new changed data to the adapter
        listadapter.notifyDataSetChanged(); // tell the adapter that the data has changed
    }
}