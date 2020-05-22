@Override
public View getView(int position, View convertView, ViewGroup parent) {
// Get the data item for this position
Item item = getItem(position);

// Check if an existing view is being reused, otherwise inflate the view
ViewHolder viewHolder; // view lookup cache stored in tag

final View result;


    viewHolder = new ViewHolder();
    LayoutInflater inflater = LayoutInflater.from(getContext());
    convertView = inflater.inflate(R.layout.row_item, parent, false);
    viewHolder.itemTitle = (TextView) convertView.findViewById(R.id.title);
    //viewHolder.itemStore = (TextView) convertView.findViewById(R.id.type);
    viewHolder.itemPrice = (TextView) convertView.findViewById(R.id.price);
    viewHolder.storeLogo = (ImageView) convertView.findViewById(R.id.store);

    result = convertView;

    convertView.setTag(viewHolder);

viewHolder.itemTitle.setText(item.getTitle());
viewHolder.itemPrice.setText("$" + item.getPrice());
viewHolder.storeLogo.setOnClickListener(this);
viewHolder.storeLogo.setTag(position);

// Return the completed view to render on screen
return convertView;

}