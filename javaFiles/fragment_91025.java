public class MyAdapter extends BaseAdapter {

private List<AdapterItem> items;

public void addAdapterItem(AdapterItem item) {
  items.add(item); 
}

public int getCount() {
  return items.size();
}

public Object getItem(int position) {
  return items.get(position);
}

public View getView(int position, View convertView, ViewGroup parent) 
  View rowView = getLayoutInflater().inflate(R.layout.rowLayout);
  TextView firstTextView = (TextView) rowView.findViewById(R.id.firstView);
  firstTextView.setText(items.get(postion).first);
  // do the same with second and third
  return rowView;
}