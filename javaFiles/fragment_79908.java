adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_2, products){
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null)
             convertView = View.inflate(getBaseContext(), android.R.layout.simple_list_item_2, null);

        ((TextView) convertView.findViewById(android.R.id.text1)).setText(products[position]);
        ((TextView) convertView.findViewById(android.R.id.text2)).setText(definitions[position]);

        return convertView;
    }
};