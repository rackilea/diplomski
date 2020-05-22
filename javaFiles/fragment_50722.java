@Override
public View getView(int position, View convertView, ViewGroup parent) {

    ViewHolder holder;

    if (convertView == null) {
        convertView = LayoutInflater.inflate(R.layout.gridview_item, null);
        holder = new ViewHolder();
        holder.image = (ImageView)convertView.findViewById(R.id.grid_image);
        holder.checkImage = (ImageView)convertView.findViewById(R.id.check_grid_image);
        convertView.setTag(holder);
    }
    GridView gridView = (GridView)parent;
    if (gridView.isItemChecked(position)) {
        holder.checkImage.setVisibility(View.VISIBLE);
    }
    else {
        holder.checkImage.setVisibility(View.INVISIBLE);
    }
// Picasso omitted

    return convertView;
}

private static class ViewHolder {
    ImageView image;
    ImageView checkImage;
}