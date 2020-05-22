@Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;

        if(row == null) {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(R.layout.grid_row, parent, false);
        }

        ImageView gridImageView = (ImageView) row.findViewById(R.id.gridImageView);

        Picasso.with(context)
               .load(thumbnailURLs.get(position))
               .placeholder(R.drawable.placeholder)
               .error(R.drawable.placeholder)
               .into(gridImageView);

        return row;
    }