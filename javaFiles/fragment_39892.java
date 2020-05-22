public class NavigationAdapter extends ArrayAdapter <String> {
private final Context context;
private final String[] titles;
private final int[] icon;

public NavigationAdapter(Context context, int[] icon, String[] titles){
    super(context, R.layout.navigation_row,titles);
    this.context=context;
    this.icon=icon;
    this.titles=titles;
}

@Override
public View getView(int position, View convertView, ViewGroup parent) {
    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    View rowView = inflater.inflate(R.layout.navigation_row,parent,false);

    ImageView imageView=(ImageView)rowView.findViewById(R.id.icon);
    TextView textView = (TextView)rowView.findViewById(R.id.name);

    imageView.setImageResource(icon[position]);
    textView.setText(titles[position]);     

    return rowView;
}