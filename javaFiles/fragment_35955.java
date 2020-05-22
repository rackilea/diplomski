@Override  
public View getView(final int position, View convertView, ViewGroup parent) {  
    View v=convertView;
    ListViewItem item = items.get(position);

    if(v==null){
        v = inflater.inflate(R.layout.my_hospitals, null);
    }
        TextView status = (TextView) v.findViewById(R.id.status);
        TextView name = (TextView) v.findViewById(R.id.name);
        TextView table = (TextView) v.findViewById(R.id.id);
        TextView info = (TextView) v.findViewById(R.id.info);

        status.setText(item.status);
        name.setText(item.name);
        table.setText(item.table);
        info.setText(item.info);     
        String state=tem.status;


        if (state.equals("green"){
            v.setBackgroundColor(Color.GREEN);
        }

    return v;  
}