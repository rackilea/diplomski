public class MainActivity extends FragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        PagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public int getCount() {
                return 4;
            }

            @Override
            public Fragment getItem(int position) {
                final ArrayList<Fragment> fragmentPosition = new ArrayList<>();
                fragmentPosition.add(new Fragment1());
                fragmentPosition.add(new Fragment2());
                fragmentPosition.add(new Fragment3());
                fragmentPosition.add(new Fragment4());
                Fragment fragment = fragmentPosition.get(position);
                Bundle args = new Bundle();
                fragment.setArguments(args);
                return fragment;
            }
        };

        // wrap pager to provide infinite paging with wrap-around
        PagerAdapter wrappedAdapter = new InfinitePagerAdapter(adapter);

        // actually an InfiniteViewPager
        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(wrappedAdapter);

    }
}