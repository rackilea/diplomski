public class ListViewAdapter extends ArrayAdapter {
private MainActivity activity;

public ListViewAdapter(MainActivity context, int resource, List<String> objects) {
    super(context, resource, objects);
    this.activity = context;
}

@Override
public View getView(int position, View convertView, ViewGroup parent) {
    ViewHolder holder;
    LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
    // If holder not exist then locate all view from UI file.
    if (convertView == null) {
        // inflate UI from XML file
        convertView = inflater.inflate(R.layout.item_listview, parent, false);
        // get all UI view
        holder = new ViewHolder(convertView);
        // set tag for holder
        convertView.setTag(holder);
    } else {
        // if holder created, get tag from view
        holder = (ViewHolder) convertView.getTag();
    }

    String item = (String)getItem(position);
    holder.friendName.setText(item);
    //get first letter of each String item
    String firstLetter = item.substring(0, 1);
    ColorGenerator generator = ColorGenerator.MATERIAL; // or use DEFAULT
    // generate random color
    int color = generator.getColor(item);
    TextDrawable drawable = TextDrawable.builder()
            .buildRound(firstLetter, color); // radius in px
    holder.imageView.setImageDrawable(drawable);
    return convertView;
}

private class ViewHolder {
    private ImageView imageView;
    private TextView friendName;

    public ViewHolder(View v) {
        imageView = (ImageView) v.findViewById(R.id.image_view);
        friendName = (TextView) v.findViewById(R.id.text);
    }
}

}