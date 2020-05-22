public void OnItemClick(AdapterView<?> parent, View, view, int position, long id){

    YourAdapterClass adapter = (YourAdapterClass) parent.getAdapter();

    // TODO check if is a valid position
    YourItem item = (YourItem) adapter.getItem(position-1);
    item.setBackgroundResource(R.drawable.li_gradient);

    adapter.notifyDataSetChanged();
}