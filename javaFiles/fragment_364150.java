private class myAdapter extends ArrayAdapter<yourclass> {

    private ArrayList<yourclass> items;

    public myAdapter(Context context, int textViewResourceId, ArrayList<yourclass> items) {
            super(context, textViewResourceId, items);
            this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            if (v == null) {
                LayoutInflater vi = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = vi.inflate(R.layout.list_item, null);
            }
            yourclass o = items.get(position);
            if (o != null) {
                    TextView tt = (TextView) v.findViewById(R.id.txt1);
                    TextView bt = (TextView) v.findViewById(R.id.txt2);
        //similarly for 2 more textviews and a imageview
                    if (tt != null) {
                          tt.setText("Name: "+o.getitemName());                            }
                    if(bt != null){
                          bt.setText("Status: "+ o.getitemStatus());
             //similarly...and getitemName ,getitemStatus are functions of your class.. to get the values..
                    }
            }
            return v;
    }