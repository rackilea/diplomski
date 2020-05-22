public class MainActivity extends Activity {

    GridView gridView;
    public MyAdapter adapter;
    static final String[] years = new String[] {
        "1863", "1864",  "1868", "1871", "1890",
        "1898", "1900", "1906", "1968", "1979"
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        gridView = (GridView) findViewById(R.id.gridView1);
        adapter = new MyAdapter(getApplicationContext(), 0);
        gridView.setAdapter(adapter);
        for (int i = 1; i < years.length; i++) {

            adapter.addAdapterItem(new AdapterItem(years[i]));
        }
    }

    public class MyAdapter extends ArrayAdapter < AdapterItem > {
        private List < AdapterItem > items = new ArrayList < AdapterItem > ();

        // private static LayoutInflater inflater=null;
        public MyAdapter(Context context, int textviewid) {
            super(context, textviewid);
        }

        public void addAdapterItem(AdapterItem item) {
            items.add(item);
        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public AdapterItem getItem(int position) {
            return ((null != items) ? items.get(position) : null);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @SuppressWarnings("deprecation")
        @Override
        public View getView(final int position, View convertView,
            final ViewGroup parent) {
            View rowView;
            if (convertView == null) {
                rowView = getLayoutInflater().inflate(R.layout.gridview_item,
                    null);
            } else {
                rowView = convertView;
            }
            TextView tv = (TextView) rowView.findViewById(R.id.item_gridview);
            tv.setText(items.get(position).first);
            if (position == 4 || position == 6) {

                tv.setTextColor(Color.parseColor("#1e1eff"));
            } else if (position == 2) {
                tv.setTextColor(Color.parseColor("#e32017"));
            } else {
                // tv.setTextColor(Color.WHITE);
            }

            return rowView;
        }
    }

    public class AdapterItem {
        public String first;

        // add more items
        public AdapterItem(String first) {
            this.first = first;

        }
    }
}