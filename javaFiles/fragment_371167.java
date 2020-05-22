MyAdapter mAdapter;
ViewPager mPager;
Stack<Integer> pageHistory;
int currentPage;
boolean saveToHistory;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mAdapter = new MyAdapter(getSupportFragmentManager());
    mPager = (ViewPager)findViewById(R.id.container);
    mPager.setAdapter(mAdapter);
    mPager.setOffscreenPageLimit(5);

    pageHistory = new Stack<Integer>();
    mPager.setOnPageChangeListener(new OnPageChangeListener() {

        @Override
        public void onPageSelected(int arg0) {
            if(saveToHistory)
                pageHistory.push(Integer.valueOf(currentPage));
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override
        public void onPageScrollStateChanged(int arg0) {
        }
    });
    saveToHistory = true;
}

@Override
public void onBackPressed() {
    if(pageHistory.empty())
        super.onBackPressed();
    else {
        saveToHistory = false;
        mPager.setCurrentItem(pageHistory.pop().intValue());
        saveToHistory = true;
    }
};