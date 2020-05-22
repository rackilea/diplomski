this.getListView().setLongClickable(true);
this.getListView().setOnItemLongClickListener(new OnItemLongClickListener() {
public boolean onItemLongClick(AdapterView<?> parent, View v, int position, long id) {
    //Do some
    kissiler.remove(position);
    adapter.notifyDataSetChanged();
    return true;
}});