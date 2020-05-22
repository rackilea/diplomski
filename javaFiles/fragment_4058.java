public YourConstructor() {
    // inflater should be a private member variable
    inflater = (LayoutInflater)context
                   .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    // other code...
}

public View getView(int position, View convertView, ViewGroup parent) {
    if(convertView == null) {
        // create new one and put it into convertView. e.g.:
        convertView = new ExpenseIcon(context);
        AbsListView.LayoutParams lp = new AbsListView.LayoutParams(HEIGHT,WIDTH);
        convertView.setLayoutParams(lp);
    }

    // set the image to the currient convertView. e.g.:
    ((ExpenseIcon)convertView).setImageBitmap(image);

    return convertView;
}