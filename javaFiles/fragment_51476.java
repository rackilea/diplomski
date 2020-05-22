public class MainActivity extends FragmentActivity {

  private FragmentPagerAdapter mAdapter;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.layout_main);
    mAdapter = new FragmentAdapter(getSupportFragmentManager());
    MyViewPager pager = (MyViewPager) findViewById(R.id.viewpager);
    pager.setGestureDetector(new GestureDetector(this, new MyGestureListener(this)));
    pager.setAdapter(mAdapter);
    pager.setCurrentItem(Math.round(mAdapter.getCount() / 2));
  }
}