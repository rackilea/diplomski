private ViewPager mViewPager;

public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager= (ViewPager) findViewById(R.id.view_pager);
        ImageAdapter adapter = new ImageAdapter(this);
        mViewPager.setAdapter(adapter);

        final GestureDetector tapGestureDetector = new GestureDetector(this, new TapGestureListener());
        mViewPager.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                tapGestureDetector.onTouchEvent(event);
                return false;
            }
        });
    }


    private class TapGestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {

            if (mViewPager.getCurrentItem() == 0) {
            //do your thing tied with first page
            } else if (mViewPager.getCurrentItem() == 1) {
            //do your thing tied with second page
            } else if (mViewPager.getCurrentItem() == 2) {
            //do your thing tied with third page
            }

            return super.onSingleTapConfirmed(e);
        }
    }