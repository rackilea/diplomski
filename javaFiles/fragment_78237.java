private class ViewHolder {    
    TextView text;
    int direction;
}

 if (convertView == null || ((ViewHolder) convertView.getTag()).direction != direction) {
    // same code you have now to layout a new row
    holder.direction = direction
} else { // we know the existing view has same direction so it has the correct layout already inflated and we can reuse it
    holder = (ViewHolder) convertView.getTag();
}