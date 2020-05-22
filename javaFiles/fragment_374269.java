public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        setUpMapIfNeeded();

        ....
        //sets up default fragment, will later be replaced with fragment when marker is selected
        if (findViewById(R.id.fragment_container) == null) {

            if (savedInstanceState != null) {
                return;
            }

            FragmentManager fm = getSupportFragmentManager();
            SelectFrag firstFragment = new SelectFrag();
            FragmentTransaction ft = fm.beginTransaction();
                ft.add(R.id.search_frag, firstFragment);
                ft.commit();
            }
...