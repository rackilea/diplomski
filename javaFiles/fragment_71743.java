public class MainActivity extends Activity {

    class City {
        public City(String city, int d) {
            this.city = city;
            this.distance = String.valueOf(d);
        }

        String city;
        String distance;
    }

    class CityAdapter extends ArrayAdapter<City> {

        public CityAdapter(Context context, List<City> objects) {
            super(context, android.R.layout.simple_list_item_2, objects);
        }

        @Override //don't override if you don't want the default spinner to be a two line view
        public View getView(int position, View convertView, ViewGroup parent) {
            return initView(position, convertView);
        }

        @Override
        public View getDropDownView(int position, View convertView,
                                    ViewGroup parent) {
            return initView(position, convertView);
        }

        private View initView(int position, View convertView) {
            if(convertView == null)
                convertView = View.inflate(getContext(),
                                           android.R.layout.simple_list_item_2,
                                           null);
            TextView tvText1 = (TextView)convertView.findViewById(android.R.id.text1);
            TextView tvText2 = (TextView)convertView.findViewById(android.R.id.text2);
            tvText1.setText(getItem(position).city);
            tvText2.setText(getItem(position).distance);
            return convertView;
        }
    }

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Spinner spinner = (Spinner)findViewById(R.id.spinner1);
        List<City> list = new ArrayList<MainActivity.City>();
        for(int i = 0; i < 10; i++)
            list.add(new City(String.format("City %d", i + 1), (i + 1) * 1000));
        spinner.setAdapter(new CityAdapter(this, list));

    }

}