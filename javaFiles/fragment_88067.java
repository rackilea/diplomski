public class View extends BaseActivity {
private FragmentPagerAdapter mPagerAdapter;
private ViewPager mViewPager;
private String mMeetingKey;


@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_view_posts);
    mViewPager = findViewById(R.id.container);
    mMeetingKey=getIntent().getStringExtra("meetingKey");

    Bundle bundle = new Bundle();
    bundle.putString("mMeetingKey", mMeetingKey);
    PostListFragment postListFragment=new PostListFragment();
     postListFragment.setArguments(bundle);


    mPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
        private final Fragment[] mFragments = new Fragment[] {
                postListFragment ,
               // new MyPostsFragment(),
               // new CompletedPostFragment(),
        };
        private final String[] mFragmentNames = new String[] {
                getString(R.string.heading_recent),
                //getString(R.string.heading_my_posts),
                //getString(R.string.heading_completed_posts)
        };
        @Override
        public Fragment getItem(int position) {
            return mFragments[position];
        }
        @Override
        public int getCount() {
            return mFragments.length;
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentNames[position];
        }
    };

    mViewPager.setAdapter(mPagerAdapter);
    TabLayout tabLayout = findViewById(R.id.tabs);
    tabLayout.setupWithViewPager(mViewPager);
    Toast.makeText(this,mMeetingKey,Toast.LENGTH_LONG).show();


    // Button launches NewPostActivity
    findViewById(R.id.fab_new_post).setOnClickListener(new android.view.View.OnClickListener() {
        @Override
        public void onClick(android.view.View v) {
            Intent intent = new Intent(View.this, NewPostActivity.class);
            intent.putExtra("mMeetingKey",mMeetingKey);
            startActivity(intent);
        }
    });
}
}