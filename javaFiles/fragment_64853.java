public class MyAdapter extends BaseAdapter {

    private Activity activity;
    private HashMap<String, String> map;

    public MyAdapter(Activity activity, HashMap<String, String> map) {
        this.activity = activity;
        this.map = map;
    }

    public int getCount() {
        return map.size();
    }    

    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.my_list_item,
                    null);
        }

            // Recommended to use a list as the dataset passed in the constructor.
            // Otherwise not sure how you going to map a position to an index in the dataset.
            String key = // get a key from the HashMap above
            String value = map.get(key);

            TextView keyView = convertView.findViewById(R.id.item_key);
            keyView.setText(key);

            TextView valueView = convertView.findViewById(R.id.item_value);
            valueView .setText(value);

        return convertView;
    }    
}