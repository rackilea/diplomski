convertView = LayoutInflater.from(context).
                        inflate(R.layout.layout_list_view_row_items, parent, false);
TextView nameTextView = (TextView) convertView.findViewById(R.id.name_text_view);


//and now get the SpinnerArrayObject by position


 SpinnerArrayObject currentObject = spinnerArrayObjects.get(position);
    nameTextView.setText(currentObject.getName());

    return convertView;