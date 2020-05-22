@Override
public View getView(int position, View convertView, ViewGroup parent) {

    final ViewHolder holder;
    if (convertView == null) {

        convertView = layoutInflater.inflate(R.layout.layout_list_row, null);

        holder = new ViewHolder();
        holder.backgroundImage = (ImageView) convertView.findViewById(R.id.backgroundImage);
        holder.topText = (TextView) convertView.findViewById(R.id.topText);
        holder.bottomText = (TextView)    convertView.findViewById(R.id.bottomText);
        TitleGuidPair titleGuidPair = list.get(position);  
        holder.topText.setText(titleGuidPair.getTitle());
        holder.bottomText.setText(titleGuidPair.getGuid());
        convertView.setTag(holder);

    } else {
        holder = (ViewHolder) convertView.getTag();
    }
    return convertView;
}