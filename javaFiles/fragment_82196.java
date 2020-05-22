public class MainActivity extends Activity {

    private RelativeLayout layout;
    private ListView listView;
    private MyRenderer selectedRenderer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        layout = new RelativeLayout(this);
        setContentView(layout);
        listView = new ListView(this);
        RelativeLayout.LayoutParams rlp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        layout.addView(listView, rlp);

        listView.setAdapter(new MyAdapter());
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // find out where the clicked view sits in relationship to the
                // parent container
                int t = view.getTop() + listView.getTop();
                int l = view.getLeft() + listView.getLeft();

                // create a copy of the listview and add it to the parent
                // container
                // at the same location it was in the listview
                selectedRenderer = new MyRenderer(view.getContext());
                RelativeLayout.LayoutParams rlp = new RelativeLayout.LayoutParams(view.getWidth(), view
                        .getHeight());
                rlp.topMargin = t;
                rlp.leftMargin = l;
                selectedRenderer.textView.setText(((MyRenderer) view).textView.getText());
                layout.addView(selectedRenderer, rlp);
                view.setVisibility(View.INVISIBLE);

                // animate out the listView
                Animation outAni = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0f,
                        Animation.RELATIVE_TO_SELF, -1f, Animation.RELATIVE_TO_SELF, 0f,
                        Animation.RELATIVE_TO_SELF, 0f);
                outAni.setDuration(1000);
                outAni.setFillAfter(true);
                outAni.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        ScaleAnimation scaleAni = new ScaleAnimation(1f, 
                                1f, 1f, 2f, 
                                Animation.RELATIVE_TO_SELF, 0.5f,
                                Animation.RELATIVE_TO_SELF, 0.5f);
                        scaleAni.setDuration(400);
                        scaleAni.setFillAfter(true);
                        selectedRenderer.startAnimation(scaleAni);
                    }
                });

                listView.startAnimation(outAni);
            }
        });
    }

    public class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return 10;
        }

        @Override
        public String getItem(int position) {
            return "Hello World " + position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            MyRenderer renderer;
            if (convertView != null)
                renderer = (MyRenderer) convertView;
            else
                renderer = new MyRenderer(MainActivity.this);
            renderer.textView.setText(getItem(position));
            return renderer;
        }
    }

    public class MyRenderer extends RelativeLayout {

        public TextView textView;

        public MyRenderer(Context context) {
            super(context);
            setPadding(20, 20, 20, 20);
            setBackgroundColor(0xFFFF0000);

            RelativeLayout.LayoutParams rlp = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            rlp.addRule(CENTER_IN_PARENT);
            textView = new TextView(context);
            addView(textView, rlp);
        }

    }
}