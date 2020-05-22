ArrayList<yourType> arrayList = new ArrayList<yourType>();
//Init data for your arrayList
//...
//Init your adapter
MyAdapter adapter = new MyAdapter(context, 0, arrayList);

//update item of listview
public void updateValue(String newValue) {
    arrayList.get(position).valueFile = newValue;
    adapter.notifyDataSetChanged();
}