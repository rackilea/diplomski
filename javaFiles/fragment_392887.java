public class CustomArrayAdapter extends ArrayAdapter<Music> {
    public CustomArrayAdapter(Context context, ArrayList<Music> musicList) {
       super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

       Music music = getItem(position); 

       // Here use that new layout that you created 
       if (convertView == null) {
          convertView = LayoutInflater.from(getContext()).inflate(R.layout.unique_layout, parent, false);
       }

       // Assign text to the TextView from that new layout
       TextView category = (TextView) convertView.findViewById(R.id.category);
       category.setText(music.category);

       return convertView;
   }
}