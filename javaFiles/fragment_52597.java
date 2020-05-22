@Override
public View getView(int position, View convertView, ViewGroup parent) {

    if(convertView == null) {
        convertView = new TextView(getApplicationContext());
    }
    ((TextView) convertView).setText(searchList.get(position));
    return convertView;
}