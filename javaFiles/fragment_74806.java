public class RelativeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative);

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new NumberGridAdapter(this, Arrays.asList(getResources().getStringArray(R.array.numbers))));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(RelativeActivity.this, "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private class NumberGridAdapter extends BaseAdapter{

        private List<String> values;
        private Context context;

        public NumberGridAdapter(Context c, List<String> numbers) {
            context = c;
            values = numbers;
        }

        @Override
        public int getCount() {
            return values.size();
        }

        @Override
        public Object getItem(int position) {
            return values.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = View.inflate(context, R.layout.grid_item_layout, null);
            }

            TextView tv = (TextView) convertView.findViewById(R.id.grid_text_view);
            tv.setText(""+position);

            return convertView;
        }
    }
}