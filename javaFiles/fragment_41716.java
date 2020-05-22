public View getView(int position, View convertView, ViewGroup parent) {

    Student std = new Student(); //this line I added
    std = myList.get(position);  //this line I added
    myViewHolder viewHolder;
    if(convertView == null){
        convertView = inflater.inflate(R.layout.single_row, null);
        viewHolder = new myViewHolder();
        convertView.setTag(viewHolder);
    } else {
        viewHolder = (myViewHolder) convertView.getTag();
    }

    viewHolder.nameTextView = (TextView) convertView.findViewById(R.id.nameTextView);
    viewHolder.cityTextView = (TextView) convertView.findViewById(R.id.cityTextView);
    viewHolder.ageTextView = (TextView) convertView.findViewById(R.id.ageTextView);

viewHolder.nameTextView.setText(myList.get(position).name);
viewHolder.cityTextView.setText(myList.get(position).city);
viewHolder.ageTextView.setText(myList.get(position).age);
return convertView;
}