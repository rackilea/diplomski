public class PicassoAdapter extends ArrayAdapter<String> {
    public PicassoAdapter(List<String> urls, Context context){
        super(context, 0, urls);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PlaceViewHolder holder;
        //ListView tries to reuse invisible Row-Views to save memory, thats why this method can be called with null OR actually a ready View
        if(convertView == null){
            //in this case we need to create a new View
            //create a holder Object that we will attach to the view
            holder = new PlaceViewHolder();
            //in this line we actually create a new row from the xml-file
            convertView = View.inflate(getContext(), R.layout.places_layout, parent, false);
            //we attach the Image- and Text-View to our holder, so we can access them in the next step
            holder.placeIcon = (ImageView)convertView.findViewById(R.id.placeicon);
            holder.placeInfo = (TextView)convertView.findViewById(R.id.placeinfo);
            convertView.setTag(holder)
        } else {
            //if the view is already created, simply get the holder-object
            holder = (PlaceViewHolder)convertView.getTag();
        }
        //I assume the URL is a String, if you need another Type, simply change it here and in class declaration
        String url = getItem(position);
        Picasso.with(getContext())
                        .load(url)
                        //now we have an ImageView, that we can use as target
                        .into(holder.placeIcon);
         //you can set the info here
         holder.placeInfo.setText("test");
         }
    }

    //we need this class as holder object
    public static class PlaceViewHolder {
        private ImageView placeIcon;
        private TextView palceInfo;
    }
}