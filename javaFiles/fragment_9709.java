@Override
public View getView(int position, View convertView, ViewGroup parent) {

if (convertView == null) {
    LayoutInflater mInflater = (LayoutInflater)
            context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
    convertView = mInflater.inflate(R.layout.list_item, null);
}

Button btnCall = (Button) convertView.findViewById(R.id.do_phone);
btnCall.setTag(position);
btnCall.setOnClickListener(new OnClickListener() {

    @Override
    public void onClick(View v) {
        Integer position = (Integer)v.getTag();
        // This calls a method back in the fragment or activity that owns the adapter
        fragment.callItemList(position);
    }
});

Button btnMap = (Button) convertView.findViewById(R.id.do_map);
btnMap.setTag(position);
btnMap.setOnClickListener(new OnClickListener() {

    @Override
    public void onClick(View v) {
        Integer position = (Integer)v.getTag();
        // This calls a method back in the fragment or activity that owns the adapter
        fragment.mapItemList(position);
    }
});

TextView txtContactPhone = (TextView) convertView.findViewById(R.id.contact_phone); 

return convertView;
}