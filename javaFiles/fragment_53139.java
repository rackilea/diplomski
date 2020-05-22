public class Example extends Activity {
    public class MyArrayAdapter<T> extends ArrayAdapter<T> {
        LayoutInflater mInflater;
        int[] mLayoutResourceIds;

        public MyArrayAdapter(Context context, int[] textViewResourceId, List<T> objects) {
            super(context, textViewResourceId[0], objects);
            mInflater = (LayoutInflater)context.getSystemService (Context.LAYOUT_INFLATER_SERVICE);
            mLayoutResourceIds = textViewResourceId;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null && position > 2)
                convertView = mInflater.inflate(mLayoutResourceIds[1], parent, false);
            return super.getView(position, convertView, parent);
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] array = new String[] {"one", "two", "three", "four", "five", "six"};
        List<String> list = new ArrayList<String>();
        Collections.addAll(list, array);

        ListView listView = new ListView(this);
        listView.setAdapter(new MyArrayAdapter<String>(this, new int[] {android.R.layout.simple_list_item_1, android.R.layout.simple_list_item_single_choice}, list));
        setContentView(listView);
    }
}