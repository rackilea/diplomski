public class Offices extends Activity {

    private ListView listView;

    /* selectedListItem will contain the number of items to be selected.
     * Your list item OnOlickListener will simply change this variable
     * to the position of the clicked item. The Adapter will do the rest 
     * because you need to refresh the ListView.
     */ 
    private int selectedListItem = -1;
    private Handler mHandler = new Handler();
    private Vector<String> data; 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.officeslayout);
        data = new Vector<String>();

        // Add data as per your requirement   
        data.add("one");
        data.add("two");
        data.add("three");
        data.add("four");
        data.add("Five");
        data.add("Six");
        data.add("Seven");
        data.add("Eight");
        data.add("Nine");
        data.add("Ten");

        listView = (ListView)findViewById(R.id.ListView01);
        listView.setDivider(null);

        listView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                    int position, long id) {

                selectedListItem = position;
                ((EfficientAdapter)listView.getAdapter()).notifyDataSetChanged();

                mHandler.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        // call any new activity here or do any thing you want here         

                    }
               }, 200L);
            }
        });

        listView.setAdapter(new EfficientAdapter(getApplicationContext()));   
    }

    private class EfficientAdapter extends BaseAdapter {
        private LayoutInflater mInflater;

        public EfficientAdapter(Context context) {
            mInflater = LayoutInflater.from(context);
        }

        public int getCount() {
            return data.size();
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder holder;

            if (convertView == null || convertView.getTag() == null) {
                convertView = mInflater.inflate(R.layout.officeslistitemlayout, null);
                holder = new ViewHolder();
                holder.backgroundView = (ImageView) convertView
                    .findViewById(R.id.OfficesBackground);
                holder.officesTitle = (TextView) convertView
                    .findViewById(R.id.OfficesName);

                convertView.setTag(holder);
            } else {
                 holder = (ViewHolder) convertView.getTag();
            }

            if(position == selectedListItem) {  
                 holder.backgroundView.setBackgroundResource(R.drawable.and_gray_bg_listing_selected);
            } else {
                 holder.backgroundView.setBackgroundResource(R.drawable.and_gray_bg_listing);
            }

            holder.officesTitle.setText(data.get(position)); 

            return convertView;
        }
    }

    static class ViewHolder {
        TextView officesTitle;
        ImageView backgroundView;
    }

}