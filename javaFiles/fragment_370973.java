SlidingTabLayout mSlidingTabLayout;
ViewPager mViewPager;
PagerAdapter mPagerAdapter;
SharedPreferences mySharedpref;

 @Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view= inflater.inflate(R.layout.fragment_home, container, false);

    mPagerAdapter=new PagerAdapter(getChildFragmentManager());
    mViewPager= (ViewPager) view.findViewById(R.id.vpPager);
    mSlidingTabLayout= (SlidingTabLayout) view.findViewById(R.id.sliding_tabs);
    mViewPager.setAdapter(mPagerAdapter);
    mSlidingTabLayout.setCustomTabView(R.layout.customtab, R.id.textView1);
    mSlidingTabLayout.setSelectedIndicatorColors(R.color.tabIndicator);
    mSlidingTabLayout.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {//change the color of the tab indcator

        @Override
        public int getIndicatorColor(int position) {
            // TODO Auto-generated method stub
            return getResources().getColor(R.color.tabIndicator);
        }
    });

    mSlidingTabLayout.setViewPager(mViewPager);
    mViewPager.setCurrentItem(tabPosition);
return view;
}