public View getView(int position, View convertView, ViewGroup parent) {

    View gridView = null;

    try {
        if (convertView == null) {
             LayoutInflater inflater = (LayoutInflater) context
                     .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

             gridView = new View(context);

             // get layout from mobile.xml
             gridView = inflater.inflate(R.layout.mobile, null);              
        }
        else
        {
             gridView = convertView;
        }

        JSONObject c = android.getJSONObject(position);

        // Storing  JSON item in a Variable
        String path = c.getString(TAG_PATH);

        // set value into textview
        TextView textView = (TextView) gridView
                .findViewById(R.id.grid_item_label);
        textView.setText(path.toString());

        // set image based on selected text
        ImageView imageView = (ImageView) gridView
                .findViewById(R.id.grid_item_image);

        Picasso.with(context).load("http://www.500kgiveaway.co.uk/" + path).resize(400,400).into(imageView);

        // Adding value HashMap key => value
        HashMap<String, String> map = new HashMap<String, String>();
        map.put(TAG_PATH, path);
        // TODO: add some checks so you don't add it if it's already in the list? 
        oslist.add(map);

     } catch (JSONException e) {
        e.printStackTrace();
    }

    return gridView;
}