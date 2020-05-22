public class CustomAdapter extends ArrayAdapter<Integer> {
     Activity context;   
     ArrayList<Integer> objects;

     public CustomAdapter(Activity context,  ArrayList<Integer> objects) {
      super(context, R.layout.row, objects);
      this.context = context;
      this.objects = objects;
     }

     @Override
     public View getView(int position, View convertView, ViewGroup parent) {

      if (convertView == null) {
       LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       convertView = inflater.inflate(R.layout.row, parent, false);


      } 

      ImageView i = (ImageView) convertView.findViewById(R.id.icon);
      i.setBackgroundResource(objects.get(position));

      TextView t = (TextView) convertView.findViewById(R.id.title);
      t.setText("title");

      return convertView;

     }

    }