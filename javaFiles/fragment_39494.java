public class GridViewAdapter extends BaseAdapter {

Context context;
ArrayList<HashMap<String, String>> data;

public GridViewAdapter(Context a, ArrayList<HashMap<String, String>> d) {
    context = a;
    data = d;
}

public int getCount() {
    return data.size();
}

public HashMap<String, String> getItem(int position) {
    return data.get(position);
}

public long getItemId(int position) {
    return position;
}

public View getView(int position, View convertView, ViewGroup parent) {

    if (convertView == null){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.upcoming_grid_item, parent, false);
     }
    ImageView poster = (ImageView) convertView.findViewById(R.id.upcoming_image);

    HashMap<String, String> mylist = data.get(position);


    String posterPath = mylist.get("poster_path");
    String url = "imageExtensionUrl" + posterPath;
    Picasso.with(context).load(url).into(poster);

    return convertView;
}
}