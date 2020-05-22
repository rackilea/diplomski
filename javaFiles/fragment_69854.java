private void setListViewAdapter() {
    Rigs = new ArrayList<Rig>();
    RigsTemp = new ArrayList<Rig>();
    adapter = new CustomListViewAdapter(ListViewActivity.this, R.layout.item_listview, RigsTemp);
    listview.setAdapter(adapter);
    listview.setTextFilterEnabled(true);
}