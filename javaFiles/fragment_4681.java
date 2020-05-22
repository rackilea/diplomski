public class CustomAdapter extends ArrayAdapter<String> {

        private final Activity context;
        private final String[] countryNames;
        private final Integer[] imgid;

        public CustomAdapter(Activity context, Integer flags[],String countryNames[]) {
            super(context, R.layout.spinner_layout, countryNames);
            // TODO Auto-generated constructor stub

            this.context=context;
            this.countryNames =countryNames;
            this.imgid=flags;
        }

        public View getView(int position,View view,ViewGroup parent) {
            LayoutInflater inflater=context.getLayoutInflater();
            View rowView=inflater.inflate(R.layout.spinner_layout, null,true);

            TextView txtTitle = (TextView) rowView.findViewById(R.id.textView2);
            ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView);

            txtTitle.setText(countryNames[position]);
            imageView.setImageResource(imgid[position]);
            return rowView;

        }
        @Override
        public View getDropDownView(int position, View convertView,ViewGroup parent) {
            return getView(position, convertView, parent);
        }

        @Override
        public String getItem(int position) {
            return String.valueOf(countryNames.toString());
        }
 }