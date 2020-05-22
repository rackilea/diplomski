public class DoubleListView extends Activity {
    ListView listView,listView2;
    String[] titles = {"List 1 title1","List 1 title2","List 1 title3","List 1 title4","List 1 title5","List 1 title6","List 1 title7","List 1 title8","List 1 title9"};
    String[] titles2 = {"List 2 title1","List 2 title2","List 2 title3","List 2 title4","List 2 title5","List 2 title6","List 2 title7","List 2 title8","List 2 title9"};
    WindowManager wm;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        wm = (WindowManager)getSystemService(Context.WINDOW_SERVICE);
        int height = wm.getDefaultDisplay().getHeight();

        listView = new ListView(this);
        listView.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,height/2-15));
        listView.setAdapter(new CustomListAdapetr(this, titles));

        listView2 = new ListView(this);
        listView2.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,height/2));
        listView2.setAdapter(new CustomListAdapetr(this, titles2));

        ((LinearLayout)findViewById(R.id.mailLayout)).addView(listView);
        ((LinearLayout)findViewById(R.id.mailLayout)).addView(listView2);

    }
    public class CustomListAdapetr extends BaseAdapter{

        private Context mContext;
        private String[] list;

        public CustomListAdapetr(Context context, String[] titles) {
            mContext = context;
            list = titles;
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return list.length;
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return list[position];
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            CustomView cv;
            if (convertView == null) {
                cv = new CustomView(mContext,""+list[position]);
                } 
            else {
                    cv = (CustomView) convertView;

                    cv.setTitle(list[position]);

                    }
            return cv;
        }

    }

    private class CustomView extends LinearLayout {
        public CustomView(Context context, String itemName) {
            super(context);
            this.setOrientation(HORIZONTAL);
            // Here we build the child views in code. They could also have
            // been specified in an XML file.


            mTitle = new TextView(context);
            mTitle.setText(itemName);

            mTitle.setTextSize(25);

            addView(mTitle, new LinearLayout.LayoutParams(200, LayoutParams.WRAP_CONTENT));


            }
        /**         * Convenience method to set the title of a SpeechView         */
        public void setTitle(String title) {
            mTitle.setText(title);
            }
        /**         * Convenience method to set the dialogue of a SpeechView         */

        private TextView mTitle;

        }

}