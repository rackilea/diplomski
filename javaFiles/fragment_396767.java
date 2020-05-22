private static final String FRAGMENT_TAG_DIALER = "fragment:dialer";

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_dialer);

    FragmentManager fm = getSupportFragmentManager();
    Fragment fragment = (DialerFragment) fm.findFragmentByTag(FRAGMENT_TAG_DIALER);

    if(fragment == null){
        fragment = new DialerFragment();
        fm.beginTransaction()
                .add(R.id.fragment_container, fragment, FRAGMENT_TAG_DIALER)
                .commit();
    }
}