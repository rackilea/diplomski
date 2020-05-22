@Override
public View getView(int position, View convertView, ViewGroup parent) {
    convertView = inflater.inflate(android.R.layout.simple_spinner_item, 
                                  parent, false);

    TextView text1 = (TextView) convertView.findViewById(android.R.id.text1);

    text1.setText(itemList[position]);

    return convertView;
}