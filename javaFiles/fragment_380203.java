public View getView(int i, View convertView, ViewGroup parent) {
    LayoutInflater inflater =
            (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    View rowView = inflater.inflate(R.layout.hrlistitems, parent, false);

    Button b = (Button) rowView.findViewById(R.id.HRlistB);
    b.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View button) {
          View listItem = (View) button.getParent();
          final long DBid = (long) listItem.getTag();//database ID

          final Button b = (Button) button;

          sqldataDataSource datasource = new sqldataDataSource(context);
          datasource.open();
          datasource.updateButton(DBid);
          datasource.close();
          //b.setBackgroundColor(0xFF386F00); no need for this line, getView() method will take care of the background
          //update your adapter dataset, eg: values.get(i).setB("newColor");
          notifyDataSetChanged(); // to refresh your adapter

        }
    });

    if(!(values.get(i).getB().equals(""))){
        b.setBackgroundColor(0xFF386F00);
    }
    return rowView;
}