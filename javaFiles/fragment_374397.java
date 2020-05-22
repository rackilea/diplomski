@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_home);

    // add the home content when just opening the app
    if(savedInstanceState == null) {
        getFragmentManager()
            .beginTransaction()
            .replace(R.id.content_home, new HomeFragment())
            .commit();
    }