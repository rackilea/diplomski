public View getView(int position, View convertView, ViewGroup parent) {
    ...
    @Override
    public void onClick(View v) {
        View parentRow = (View) v.getParent();
        ListView listView = (ListView) parentRow.getParent();
        ...
}