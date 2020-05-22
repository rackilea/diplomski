@Override
public View getView(int position, View convertView, ViewGroup parent) {

View v = convertView;
if (v == null) {
    LayoutInflater vi = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    v = vi.inflate(R.layout.alarm_list_item, null);
}


if(list.get(position).get("alert") == null){    
    v.findViewById(R.id.ListViewItemSub).setVisibility(View.GONE);
}

return super.getView(position, convertView, parent);

}