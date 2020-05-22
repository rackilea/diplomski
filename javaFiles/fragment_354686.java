setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, listitems) {
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = super.getView(position, convertView, parent);
        //v.setBackgroundColor(0xffff0000);  // COLOR
        v.setBackgroundResource(R.drawable.plaincell); // IMAGE
        return v;
    }
});