public View getDropDownView(int position, View convertview, ViewGroup parent) {
        View v = convertview;
        determineViewBeingProcessed(v,"GetDDV",position);
        if( v == null) {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_aisle_shop_list_entry, parent, false);
            //return v;
        }
        Context context = v.getContext();
        Cursor cursor = getCursor();
        cursor.moveToPosition(position);


        TextView shopname = (TextView) v.findViewById(R.id.aasletv01);

        shopname.setText(cursor.getString(shops_shopname_offset));

        if(position % 2 == 0) {
            v.setBackgroundColor(ContextCompat.getColor(context,R.color.colorlistviewroweven));
        } else {
            v.setBackgroundColor(ContextCompat.getColor(context,R.color.colorlistviewrowodd));
        }
        return v;
    }