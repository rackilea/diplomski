static class ViewHolder {
    TextView v1;
    TextView v2;
    TextView v3;
    TextView v4;
}

@Override
public View getView(int position, View convertView, ViewGroup parent) {
    final Appointment temp = getItem(position);
    ViewHolder viewHolder;

    if (convertView == null) { //inflate convertView and populate viewHolder
        viewHolder = new ViewHolder();
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.yourLayout, parent, false);
        viewHolder.v1= (TextView) convertView.findViewById(R.id.lblTime);
        viewHolder.v2= (TextView) convertView.findViewById(R.id.lblSubject);
        viewHolder.v3= (TextView)convertView.findViewById(R.id.lblLocation);
        viewHolder.v4= (TextView) convertView.findViewById(R.id.lblCustomer);
        convertView.setTag(viewHolder); //set the tag
    }
    else {
        viewHolder = (ViewHolder) convertView.getTag(); //re-use the ViewHolder to     save calls to findViewById
    }
    viewHolder.v1.setText(temp.getText1());
    viewHolder.v2.setText(temp.getText2());
    viewHolder.v3.setText(temp.getText3());
    viewHolder.v4.setText(temp.getText4());
    return convertView;
}