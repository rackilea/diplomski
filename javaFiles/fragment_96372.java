@Override
public View newView(Context context, Cursor cursor, ViewGroup parent) {
      LayoutInflater inflater = LayoutInflater.from(context); // you should put this in the constructor so you don't do it every time the newView() method is called
      View row = inflater.inflate(R.layout.row_layout, null);
      // even implement the view holder pattern for a small performance boost
      ViewHolder holder = new ViewHolder();
      holder.image = (ImageView) row.findViewById(R.id.the_id_of_the_image); 
      row.setTag(holder);
      return row;
}