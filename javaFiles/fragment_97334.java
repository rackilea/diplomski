public class myAdapter extends BaseAdapter{   
         private String latitude;
         private String longitude;
         private ArrayList<Item> items;
         private Context context; // TODO: use it for layoutInflater

        //the constructor
        public myAdapter(Context context, ArrayList<myItems> list, String latitude, String longitude) {
            this.items = list;
            this.latitude = latitude;
            this.longitude = longitude;
            this.context = context;
        }
         .....
        TextView Location = (TextView) convertView.findViewById(R.id.text_location);
            String coordinates="Lat: " + this.latitude + "  Long: " + this.longitude;
            Location.setText(coordinates);