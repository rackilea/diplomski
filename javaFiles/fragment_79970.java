@Override
public View getView(int position, View convertView, ViewGroup parent) {

convertView = inflter.inflate(R.layout.custom_spinner_items, null);
TextView names = (TextView) convertView.findViewById(R.id.textView);
names.setText(countryNames.get(position).getTargetName());
return convertView;
}