public View getView(int position, View convertView, ViewGroup parent) {
    ViewHolder holder;
    // '...' parts starts
    if (convertView == null) {
        convertView = mInflater.inflate(R.layout.your_layout, null);

        holder = new ViewHolder();
        holder.text = (TextView) convertView.findViewById(R.id.text);

        convertView.setTag(holder);
    } else {
        holder = convertView.getTag();
    }
    holder.text.setText("Position " + position);
    // '...' parts ends

    holder.position = position;

    return convertView;
}