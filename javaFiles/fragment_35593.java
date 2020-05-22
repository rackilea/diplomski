private class MyAdapter extends ArrayAdapter<String> {
    public MyAdapter() {
        super(MyActivity.this, R.layout.simplerow, contactlist);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = super.getView(position, convertView, parent);

        if (some_condition)
            v.setBackgroundResource(R.color.color_2);

        return v;
    }
}

@Override
protected void onCreate(Bundle savedInstanceState) {
    ...
    listAdapter = new MyAdapter();
    mainListView.setAdapter(listAdapter);
    ...
    // remove your setBackgroundResource code from here
}