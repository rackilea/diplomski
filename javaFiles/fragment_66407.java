private List<ListModel> listData;
....
listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(...);
        // Get the object that has been clicked
        ListModel listModel = listData.get(position);
        // Pass it to your activity
        i.putExtra("TAG", listModel);
        startActivity(i);
    }
});