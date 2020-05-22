public void CreateListView(Activity activity) {
    ListView list_View1 = (ListView) activity.findViewById(R.id.listview1);
    final String[] listViewStrings = new String[]{"first_item", "second_item", "third_item", "fouth_item", "fifth_item", "sixth_item", "seventh_item", "eigth_item"};
    ArrayAdapter list_adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,listViewStrings);
    list_View1.setAdapter(list_adapter); // Use data, pass the adapter with the strings, numbers, etc.
}