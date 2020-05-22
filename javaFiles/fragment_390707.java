@Override
public View getView(int position, View convertView, ViewGroup parent) {
    Todo item = getItem(position);

    if (convertView == null) {
        convertView = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_list_item_2, parent, false);
    }

    TextView text1 = (TextView) convertView.findViewById(android.R.id.text1);
    TextView text2 = (TextView) convertView.findViewById(android.R.id.text2);

    text1.setText(item.itemText);
    text2.setText(item.getCreationTimeString());
    text2.setTextSize(10);

    return convertView;
}