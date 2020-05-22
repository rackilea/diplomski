public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private SectionsPageAdapter mSectionsPageAdapter;
    private ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: Starting.");

        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

    private void setupViewPager(ViewPager viewPager) {

        mSectionsPageAdapter.addFragment(new home_fragment(), "Home");
        mSectionsPageAdapter.addFragment(new scan_pintje(), "scan pintje");
        mSectionsPageAdapter.addFragment(new controleer_pintje(), "controle pintje");
        mSectionsPageAdapter.addFragment(new beste_zuiper(), "beste drinkers");
        viewPager.setAdapter(mSectionsPageAdapter);
    }
}