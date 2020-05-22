if (convertView == null) {
        convertView = (View) inflater.inflate(R.layout.view_item, null);
        viewHolder = new ViewHolder();
        viewHolder.itemName = (TextView) convertView.findViewById(R.id.item_name);
        viewHolder.secondLine = (TextView) convertView.findViewById(R.id.second_line)
        convertView.setTag(viewHolder);
    }
    else {
        viewHolder = (ViewHolder) convertView.getTag();
    }

    if(<-- your condition here-->){
        secondLine.setVisibility(View.VISIBLE);
    }
    else{
        secondLine.setVisibility(View.GONE);
    }