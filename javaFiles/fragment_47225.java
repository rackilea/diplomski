if (convertView == null) {
    gridView = inflater.inflate(R.layout.grid_element, null);
} else {
    gridView = convertView;
}

ImageView logo = (ImageView) gridView.findViewById(R.id.grid_logo);

TextView tv = (TextView) gridView.findViewById(R.id.grid_textView1);
tv.setText(level + position);