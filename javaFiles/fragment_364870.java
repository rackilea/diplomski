public class MainActivity extends AppCompatActivity implements FirstFragment.OnFirstFragmentReadyListener,
        SecondFragment.OnSecondFragmentReadyListener, ThirdFragment.OnThirdFragmentReadyListener {

    ...

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager =(ViewPager) findViewById(R.id.pager);
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        // Don't call these functions here, spread them into callbacks.
        // init();
        // Action();
    }

    @Override
    public void onFirstFragmentReady() {
        TextView firstTextView = (TextView) findViewById(R.id.first_label);
        ...
        // Now you have the views from FirstFragment instance.
        // You can now call setText() or setOnClickListener() here.
    }

    @Override
    public void onSecondFragmentReady() {
        TextView secondTextView = (TextView) findViewById(R.id.second_label);
        ...
        // Now you have the views from SecondFragment instance.
        // You can now call setText() or setOnClickListener() here.
    }

    @Override
    public void onThirdFragmentReady() {
        TextView thirdTextView = (TextView) findViewById(R.id.third_label);
        ...
        // Now you have the views from ThirdFragment instance.
        // You can now call setText() or setOnClickListener() here.
    }
}